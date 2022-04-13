package Mobile_UI.AppTwoPageFactory.POM

import Core.DriverHolder
import Core.DriverHolder.Companion.driver
import Core.DriverHolder.Companion.getDriver
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import io.appium.java_client.remote.MobilePlatform.ANDROID
import org.junit.jupiter.api.condition.OS
import org.openqa.selenium.support.PageFactory



open class Page() {
    var driver: AppiumDriver<MobileElement> = DriverHolder.getDriver("0.0.0.0", 4565)
    init {
        this.driver = driver
        PageFactory.initElements(AppiumFieldDecorator(driver), this)
    }
}