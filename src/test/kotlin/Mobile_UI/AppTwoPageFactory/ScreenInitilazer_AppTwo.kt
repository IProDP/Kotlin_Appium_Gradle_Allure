package Mobile_UI.AppTwoPageFactory

import Mobile_UI.AppTwoPageFactory.POM.StartScreen_AppTwo
import Mobile_UI.CoreMobile.*
import Mobile_UI.CoreMobile.DriverHolder.Companion.environment


object ScreenInitilazer_AppTwo {

    data class ScreenInit(
        val startScreen_AppTwo: StartScreen_AppTwo,
        val screenRecordingAttachment: ScreenRecordingAttachment,
        val screenshot: Screenshot
    )

    val startScreen_AppTwo by lazy {
        screens[environment]!!.startScreen_AppTwo
    }
    val screenRecording by lazy {
        screens[environment]!!.screenRecordingAttachment
    }
    val screenshot by lazy {
        screens[environment]!!.screenshot
    }

    private val screens = mapOf(
        "Android" to ScreenInit(
            startScreen_AppTwo = StartScreen_AppTwo(),
            screenRecordingAttachment = ScreenRecording_Attachment_Android(),
            screenshot = Screenshot_Android()
        ),
        "IOS" to ScreenInit(
            startScreen_AppTwo = StartScreen_AppTwo(),
            screenRecordingAttachment = ScreenRecording_Attachment_IOS(),
            screenshot = Screenshot_IOS()

        )
    )
}