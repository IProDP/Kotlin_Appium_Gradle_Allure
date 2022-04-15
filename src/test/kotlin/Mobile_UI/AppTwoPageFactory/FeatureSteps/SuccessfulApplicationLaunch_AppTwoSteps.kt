package Mobile_UI.AppTwoPageFactory.FeatureSteps

import Mobile_UI.AppTwoPageFactory.POM.StartScreen_AppTwo
import Mobile_UI.AppTwoPageFactory.ScreenInitilazer_AppTwo.startScreen_AppTwo
import Mobile_UI.CoreMobile.DriverHolder.Companion.driver
import Mobile_UI.CoreMobile.Helper
import io.cucumber.java8.En
import org.junit.Assert


class SuccessfulApplicationLaunch_AppTwoSteps : En {


    init {

        Given("First description {string} displayed on the main screen") {descriptionFirst: String ->
            Helper.setImplicityWaitDriver(200, driver)
            Assert.assertEquals(descriptionFirst, startScreen_AppTwo.isPhpFirstDescriptionVisible2().getAttribute("text"))
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