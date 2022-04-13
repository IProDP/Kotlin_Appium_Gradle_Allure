package Mobile_UI.AppOneScreenInit.POM

import Core.DriverHolder.Companion.driver
import io.appium.java_client.MobileElement
import org.openqa.selenium.By

abstract class StartScreen_AppOne() {

    abstract fun _phpFirstDescription(): MobileElement
    abstract fun _phpSecondDescription(): MobileElement
    abstract fun _letsGoBtnTextTitle(): MobileElement
    abstract fun _letsGoBtn(): MobileElement

}

class StartScreen_AppOne_Android: StartScreen_AppOne(){

        override fun _phpFirstDescription(): MobileElement = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]"))
        override fun _phpSecondDescription(): MobileElement = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]"))
        override fun _letsGoBtnTextTitle(): MobileElement = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[3]/android.view.View"))
        override fun _letsGoBtn(): MobileElement = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[3]"))
        }

class StartScreen_AppOne_IOS: StartScreen_AppOne(){

        override fun _phpFirstDescription(): MobileElement = driver.findElement(By.xpath("PLACEHOLDER"))
        override fun _phpSecondDescription(): MobileElement = driver.findElement(By.xpath("PLACEHOLDER"))
        override fun _letsGoBtnTextTitle(): MobileElement = driver.findElement(By.xpath("PLACEHOLDER"))
        override fun _letsGoBtn(): MobileElement = driver.findElement(By.xpath("PLACEHOLDER"))

        }