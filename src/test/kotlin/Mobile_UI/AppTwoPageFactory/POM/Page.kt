package Mobile_UI.AppTwoPageFactory.POM

import Mobile_UI.CoreMobile.DriverHolder
import Mobile_UI.CoreMobile.DriverHolder.Companion.driver
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import org.openqa.selenium.support.PageFactory



open class Page() {

    init {
        PageFactory.initElements(driver, this)
    }
}