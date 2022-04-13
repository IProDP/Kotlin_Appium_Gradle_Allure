package Mobile_UI.AppTwoPageFactory.FeatureSteps

import Core.DriverHolder.Companion.getDriver
import Mobile_UI.AppTwoPageFactory.POM.Page
import Mobile_UI.AppTwoPageFactory.POM.StartScreen_AppTwo
import io.cucumber.java8.En
import org.junit.Assert
import org.junit.Test


class SuccessfulApplicationLaunch_AppTwoSteps : En {

    var page: Page = Page()
    var startScreen_AppTwo: StartScreen_AppTwo = StartScreen_AppTwo()
    init {

        Given("First description {string} displayed on the main screen") {descriptionFirst: String ->
            Core.Helper.setImplicityWaitDriver(10, startScreen_AppTwo.driver)
            Assert.assertTrue(startScreen_AppTwo.isPhpFirstDescriptionVisible())
            Assert.assertEquals(descriptionFirst,startScreen_AppTwo.textPhpFirstDescription())
        }
        Then("Second description {string} displayed on the main screen") {descriptionSecond: String ->
            Assert.assertEquals(descriptionSecond,startScreen_AppTwo.textPhpSecondDescription())
        }
        Then("{string} button displayed on the main screen") {letsGoBtn: String ->
            Assert.assertEquals(letsGoBtn,startScreen_AppTwo.textletsGoBtnTextTitle())
        }
        Then("LET’S GO! button clickable on the main screen") {
            Assert.assertEquals("true",startScreen_AppTwo.isletsGoBtnClickable())
        }
    }
}