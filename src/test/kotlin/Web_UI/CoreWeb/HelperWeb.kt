package Web_UI.CoreWeb

import Web_UI.CoreWeb.DriverHolderWeb.Companion.driver
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import java.util.concurrent.TimeUnit

abstract class HelperWeb {
    companion object {

        fun setImplicityWait(time: Long) {
            driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS)
        }

        fun setImplicityWaitDriver(time: Long, driver: WebDriver) {
            driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS)
        }

        fun  setWindowSize (width: Int, height: Int){
            driver.manage().window().size.height.and(width)
        }

    }
}
