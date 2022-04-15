package Mobile_UI.CoreMobile

import Mobile_UI.CoreMobile.DriverHolder.Companion.driver
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import java.util.concurrent.TimeUnit

abstract class Helper {
    companion object {

        fun setImplicityWait(time: Long) {
            driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS)
        }

        fun setImplicityWaitDriver(time: Long, driver: AppiumDriver<MobileElement>) {
            driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS)
        }

    }
}
