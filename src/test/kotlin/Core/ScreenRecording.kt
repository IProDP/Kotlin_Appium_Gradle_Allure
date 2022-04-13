package Core

import Core.DriverHolder.Companion.driver
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.ios.IOSDriver
import io.appium.java_client.ios.IOSStartScreenRecordingOptions
import io.qameta.allure.Attachment
import org.openqa.selenium.WebDriverException
import java.util.*

interface ScreenRecording {

    @Attachment(value = "Page screenshot", type = "video/mp4", fileExtension = ".mp4")
    fun startRecording()
    fun stopRecording(): ByteArray?
}


abstract class BaseScreenRecording: ScreenRecording {

    protected fun ignoreWebDriverException(block: () -> Unit) {
        try {
            block()
        } catch (e: WebDriverException) {}
    }

    protected fun stopRecordingIgnoreWebDriverException(block: () -> ByteArray) : ByteArray? {
        return try {
            block()
        } catch (e: WebDriverException) {
            null
        }
    }
}

class ScreenRecording_Android: BaseScreenRecording() {

    private val android: AndroidDriver<MobileElement> get() = driver as AndroidDriver<MobileElement>

    override fun startRecording() {
        ignoreWebDriverException {
            android.startRecordingScreen()
        }
    }

    override fun stopRecording(): ByteArray? {
        return stopRecordingIgnoreWebDriverException {
            val base64String: String = android.stopRecordingScreen()
            val data: ByteArray = Base64.getDecoder().decode(base64String)
            data

        }
    }
}
class ScreenRecording_IOS: BaseScreenRecording() {

    private val iOS: IOSDriver<MobileElement> get() = driver as IOSDriver<MobileElement>

    override fun startRecording() {
        ignoreWebDriverException {
            iOS.startRecordingScreen(IOSStartScreenRecordingOptions().withVideoType("libx264"))
        }
    }

    override fun stopRecording(): ByteArray? {
        return stopRecordingIgnoreWebDriverException {
            Base64.getDecoder().decode(iOS.stopRecordingScreen())
        }
    }
}