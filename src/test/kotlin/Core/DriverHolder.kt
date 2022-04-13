package Core

import Core.KeyPaths.Companion.pathToAppiumMainJs
import Core.KeyPaths.Companion.pathToNodejs
import Core.ProjectCapabilities.Companion.BaseCapabilities
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.ios.IOSDriver
import io.appium.java_client.service.local.AppiumDriverLocalService
import io.appium.java_client.service.local.AppiumServiceBuilder
import org.openqa.selenium.SessionNotCreatedException
import org.openqa.selenium.remote.DesiredCapabilities
import java.io.File
import java.net.URL
import java.util.concurrent.TimeUnit
import kotlin.test.DefaultAsserter.fail


abstract class DriverHolder {
    companion object {
        lateinit var driver: AppiumDriver<MobileElement>

        val environment: String by lazy {
            System.getProperty("platform", "Android")
            //System.getenv("ENVIRONMENT") ?: "none"
        }
        val project: String by lazy {
            System.getProperty("project", "AppTwo_Emulator")
            //System.getenv("ENVIRONMENT") ?: "none"
        }
        val tags: String by lazy {
            System.getProperty("tags", "@Smoke")
            //System.getenv("ENVIRONMENT") ?: "none"
        }

        var appiumService: AppiumDriverLocalService? = null

        fun initAppiumService(ipAddress: String, port: Int) {

            appiumService = AppiumDriverLocalService.buildService(
                AppiumServiceBuilder()
//                        .usingAnyFreePort()
                    .withAppiumJS(File(pathToAppiumMainJs()))
                    .usingDriverExecutable(File(pathToNodejs()))
//                        .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
//                        .withArgument(GeneralServerFlag.LOG_LEVEL, "error")
//                        .withArgument(GeneralServerFlag.RELAXED_SECURITY)
//                        .withLogFile(File("target/appium.log"))
                    .withStartUpTimeOut(60, TimeUnit.SECONDS)
                    .withIPAddress(ipAddress)
                    .usingPort(port)
            )
            println("New Appium service: " + appiumService?.getUrl())

            appiumService?.start()
        }

        private var caps: DesiredCapabilities? = BaseCapabilities(environment)
        lateinit var webDriverURL: URL

        fun getDriver(ipAddress: String, port: Int): AppiumDriver<MobileElement> {
            do {
                if (appiumService == null) {
                    try {
                        initAppiumService(ipAddress, port)
                        println("***AppiumService start with IP adress: $ipAddress ***")
                    } catch (e: SessionNotCreatedException) {
                        println("*********************************")
                        fail("***Cannot start Appium Session***")
                    }
                } else {
                    try {
                        appiumService?.stop()
                        initAppiumService(ipAddress, port)
                    } catch (e: SessionNotCreatedException) {
                        println("*********************************")
                        println("***Cannot start Appium Session***")
                    }
                }
            } while (appiumService == null)
            webDriverURL = URL("http://$ipAddress:$port/wd/hub")
            caps = BaseCapabilities(environment)

            when (environment) {
                "Android" -> driver = AndroidDriver(webDriverURL, caps)
                "IOS" -> driver = IOSDriver(webDriverURL, caps)
                else -> throw Exception("There is no such Environment!")
            }
            return driver
        }
    }
}