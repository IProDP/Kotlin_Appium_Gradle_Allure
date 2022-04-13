package Mobile_UI.AppTwoPageFactory.POM

import Core.DriverHolder
import Mobile_UI.AppOneScreenInit.POM.StartScreen_AppOne
import Mobile_UI.AppOneScreenInit.POM.StartScreen_AppOne_Android
import Mobile_UI.AppOneScreenInit.POM.StartScreen_AppOne_IOS
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.ios.IOSDriver
import io.appium.java_client.pagefactory.*
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.PageFactory


class StartScreen_AppTwo(): Page(){



        @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]")
        @iOSXCUITFindBy(xpath = "PLACEHOLDER")
        private var phpFirstDescription: MobileElement? = null

        @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]")
        @iOSXCUITFindBy(xpath = "PLACEHOLDER")
        private var phpSecondDescription: MobileElement? = null

        @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[3]/android.view.View")
        @iOSXCUITFindBy(xpath = "PLACEHOLDER")
        var letsGoBtnTextTitle: MobileElement? = null

        @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[3]")
        @iOSXCUITFindBy(xpath = "PLACEHOLDER")
        var letsGoBtn: MobileElement? = null

        init {
            var page: Page = Page()
            PageFactory.initElements(AppiumFieldDecorator(page.driver), this)
        }


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
            return phpFirstDescription?.text!!
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
