package Web_UI.AppOneWeb.FeatureSteps

import Mobile_UI.CoreMobile.AllureReport
import Web_UI.CoreWeb.DriverHolderWeb.Companion.driver
import Web_UI.CoreWeb.DriverHolderWeb.Companion.getDriverWeb
import Web_UI.CoreWeb.DriverHolderWeb.Companion.jmindBaseURL
import io.cucumber.java8.En
import io.cucumber.java8.Scenario
import org.openqa.selenium.WebDriverException


class HooksForSteps_AppOneWeb : En {

    init {
        Before { scenario: Scenario ->
            println(scenario.name)
            AllureReport.setAllureEnvironment()
            getDriverWeb()
            driver.get(jmindBaseURL)
        }

        After { scenario: Scenario ->
            try {
                if (scenario.isFailed || scenario.status.toString() == "UNDEFINED") {
                    println("Driver has not been initialized**, Step failed - scennario status: ${scenario.status.toString()}")
                }
                else driver.quit()

            }catch (e: WebDriverException) {
                println("Driver has not been initialized***, Step failed - scennario status: ${scenario.status.toString()}")
                driver.quit()
            }
        }
    }
}







