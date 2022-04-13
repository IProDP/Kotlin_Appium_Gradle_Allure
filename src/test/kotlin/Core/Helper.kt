package Core

import Core.DriverHolder.Companion.driver
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileBy
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.AndroidTouchAction
import io.appium.java_client.touch.WaitOptions
import io.appium.java_client.touch.offset.PointOption
import org.openqa.selenium.Rectangle
import java.awt.Toolkit
import java.awt.datatransfer.Clipboard
import java.awt.datatransfer.DataFlavor
import java.time.Duration
import java.util.concurrent.TimeUnit
import kotlin.random.Random

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
