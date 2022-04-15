package Mobile_UI.AppOneScreenInit

import Mobile_UI.AppOneScreenInit.POM.*
import Mobile_UI.CoreMobile.*
import Mobile_UI.CoreMobile.DriverHolder.Companion.environment


object ScreenInitilazer_AppOne {

    data class ScreenInit(
        val startScreen_AppOne: StartScreen_AppOne,
        val screenRecordingAttachment: ScreenRecordingAttachment,
        val screenshot: Screenshot
    )

    val startScreen by lazy {
        screens[environment]!!.startScreen_AppOne
    }
    val screenRecording by lazy {
        screens[environment]!!.screenRecordingAttachment
    }
    val screenshot by lazy {
        screens[environment]!!.screenshot
    }

    private val screens = mapOf(
        "Android" to ScreenInit(
            startScreen_AppOne = StartScreen_AppOne_Android(),
            screenRecordingAttachment = ScreenRecording_Attachment_Android(),
            screenshot = Screenshot_Android()
        ),
        "IOS" to ScreenInit(
            startScreen_AppOne = StartScreen_AppOne_IOS(),
            screenRecordingAttachment = ScreenRecording_Attachment_IOS(),
            screenshot = Screenshot_IOS()

        )
    )
}