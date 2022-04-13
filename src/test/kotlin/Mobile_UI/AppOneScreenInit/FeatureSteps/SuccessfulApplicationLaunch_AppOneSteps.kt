package Mobile_UI.AppOneScreenInit.FeatureSteps

import Core.Helper.Companion.setImplicityWait
import Mobile_UI.AppOneScreenInit.ScreenInitilazer_AppOne.startScreen
import io.cucumber.java8.En
import org.junit.Assert


class SuccessfulApplicationLaunch_AppOneSteps : En {

    init {
        Given("First description {string} displayed on the main screen") {descriptionFirst: String ->
            setImplicityWait(30)
            Assert.assertEquals(descriptionFirst,startScreen._phpFirstDescription().getAttribute("text"))
        }
        Then("Second description {string} displayed on the main screen") {descriptionSecond: String ->
            Assert.assertEquals(descriptionSecond,startScreen._phpSecondDescription().getAttribute("text"))
        }
        Then("{string} button displayed on the main screen") {letsGoBtn: String ->
            Assert.assertEquals(letsGoBtn,startScreen._letsGoBtnTextTitle().getAttribute("text"))
        }
        Then("LET’S GO! button clickable on the main screen") {
            Assert.assertEquals("true",startScreen._letsGoBtn().getAttribute("clickable"))
        }
    }
}