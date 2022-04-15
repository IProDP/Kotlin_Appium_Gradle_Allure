package Web_UI.AppOneWeb.FeatureSteps

import Web_UI.AppOneWeb.ScreenInitilazer_AppOneWeb.homePage
import Web_UI.CoreWeb.DriverHolderWeb.Companion.driver
import Web_UI.CoreWeb.HelperWeb
import Web_UI.CoreWeb.HelperWeb.Companion.setWindowSize
import com.aventstack.extentreports.gherkin.model.Given
import io.cucumber.java8.En
import io.qameta.allure.Allure
import org.junit.Assert


class SuccessfulLaunchHomePageSteps : En {
    init {
        Given("Home page opened") {
         Assert.assertTrue(homePage.isTextTitleJMINDVisible())
        }
        Then("{string} button is displayed on the Home page") {aboutUs: String ->
        Assert.assertTrue(homePage.isAboutUsVisible())
        Assert.assertEquals(aboutUs, homePage.textTitleAboutUs())
        }
        When("I clicked on the About us button") {
            homePage.clickAboutUsBtn()
        }
    }
}