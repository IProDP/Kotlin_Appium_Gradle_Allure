package Mobile_UI.AppOneScreenInit.FeatureSteps

import Mobile_UI.CoreMobile.AllureReport
import Mobile_UI.CoreMobile.AllureReport.Companion.saveScreenshot
import Mobile_UI.CoreMobile.AllureReport.Companion.saveVideo
import Mobile_UI.CoreMobile.DriverHolder.Companion.driver
import Mobile_UI.CoreMobile.DriverHolder.Companion.getDriver
import Mobile_UI.CoreMobile.Helper.Companion.setImplicityWait
import Mobile_UI.AppOneScreenInit.ScreenInitilazer_AppOne.screenRecording
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException
import io.cucumber.java8.En
import io.cucumber.java8.Scenario
import io.qameta.allure.Allure
import org.openqa.selenium.SessionNotCreatedException
import org.openqa.selenium.WebDriverException
import java.io.FileInputStream


class HooksForSteps_AppOne : En {

    init {
        var port: Int = 4524

        Before { scenario: Scenario ->
            println(scenario.name)
            AllureReport.setAllureEnvironment()
            try {
                getDriver("127.0.0.1", port)
                screenRecording.startRecording()
                setImplicityWait(30)
            }catch (e: AppiumServerHasNotBeenStartedLocallyException) {
                println("The local appium server has not been started.")
                port++
                getDriver("127.0.0.1", port)
            }catch (e: WebDriverException) {
                println("Cannot start the ${driver.capabilities.getCapability("appPackage").toString()} application. ${WebDriverException.DRIVER_INFO}")
                port++
                getDriver("127.0.0.1", port)
            }catch (e: SessionNotCreatedException) {
                println("Unable to create a new remote session. ${SessionNotCreatedException.DRIVER_INFO}")
                port++
                getDriver("127.0.0.1", port)
            }
        }

        After { scenario: Scenario ->
            try {
                if (scenario.isFailed || scenario.status.toString() == "UNDEFINED") {
                    Allure.addAttachment(scenario.name,FileInputStream(saveVideo(screenRecording.stopRecording())))
                    Allure.addAttachment(scenario.name, saveScreenshot()?.let { FileInputStream(it) })
                    println("Driver has not been initialized**, Step failed - scennario status: ${scenario.status.toString()}")
                    driver.resetApp()
                    driver.closeApp()
                }
                else driver.closeApp()

            }catch (e: UninitializedPropertyAccessException) {
                println("Driver has not been initialized***, Step failed - scennario status: ${scenario.status.toString()}")
                driver.resetApp()
                driver.closeApp()
            } catch (e: NullPointerException) {
//                println("Video Stream has already saved, because the scennario status: ${scenario.status.toString()}")
//                driver.resetApp()
//                driver.closeApp()
//            } catch (e: NoSuchElementException) {
//                println("NoSuchElementException - Appium didnt find element. Status: ${scenario.status.toString()}")
//                driver.resetApp()
//                driver.closeApp()
//            } finally {
//                if (appiumService?.isRunning == true) {
//                    appiumService?.stop()
//                }
            }
        }
    }
}







