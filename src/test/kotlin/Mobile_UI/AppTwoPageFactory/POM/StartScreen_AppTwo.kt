package Mobile_UI.AppTwoPageFactory.POM

import Mobile_UI.CoreMobile.DriverHolder.Companion.driver
import io.appium.java_client.MobileElement
import io.appium.java_client.pagefactory.*
import org.openqa.selenium.By
import org.openqa.selenium.support.PageFactory



class StartScreen_AppTwo(){

    init {
        PageFactory.initElements(AppiumFieldDecorator(driver), this)
    }

        @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]")
        @iOSXCUITFindBy(xpath = "PLACEHOLDER")
        var phpFirstDescription: MobileElement? = null

        @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]")
        @iOSXCUITFindBy(xpath = "PLACEHOLDER")
        var phpSecondDescription: MobileElement? = null

        @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[3]/android.view.View")
        @iOSXCUITFindBy(xpath = "PLACEHOLDER")
        var letsGoBtnTextTitle: MobileElement? = null

        @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[3]")
        @iOSXCUITFindBy(xpath = "PLACEHOLDER")
        var letsGoBtn: MobileElement? = null

        fun isPhpFirstDescriptionVisible2 (): MobileElement = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]"))

        fun letsGotoRegistration(): StartScreen_AppTwo {
            letsGoBtn?.click()
            return this
        }
        fun isPhpFirstDescriptionVisible(): Boolean {
            return phpFirstDescription?.isSelected!!
        }
        fun isphpSecondDescriptionVisible(): Boolean {
            return phpSecondDescription?.isDisplayed!!
        }
        fun isletsGoBtnTextTitleVisible(): Boolean {
            return letsGoBtnTextTitle?.isDisplayed!!
        }
        fun isletsGoBtnVisible(): Boolean {
            return letsGoBtn?.isDisplayed!!
        }
        fun textPhpFirstDescription(): String {
            return phpFirstDescription?.getAttribute("text")!!
        }
        fun textPhpSecondDescription(): String {
            return phpSecondDescription?.getAttribute("text")!!
        }
        fun textletsGoBtnTextTitle(): String {
            return letsGoBtnTextTitle?.getAttribute("text")!!
        }
        fun isletsGoBtnClickable(): Boolean {
            return letsGoBtn?.getAttribute("clickable").toBoolean()
        }
    }
