package Mobile_UI.AppOneScreenInit

import Core.*
import Mobile_UI.AppOneScreenInit.POM.*
import Core.DriverHolder.Companion.environment


object ScreenInitilazer_AppOne {

    data class ScreenInit(
        val startScreen_AppOne: StartScreen_AppOne,
        val screenRecording: ScreenRecording,
        val screenshot: Screenshot
    )

    val startScreen by lazy {
        screens[environment]!!.startScreen_AppOne
    }
    val screenRecording by lazy {
        screens[environment]!!.screenRecording
    }
    val screenshot by lazy {
        screens[environment]!!.screenshot
    }

    private val screens = mapOf(
        "Android" to ScreenInit(
            startScreen_AppOne = StartScreen_AppOne_Android(),
            screenRecording = ScreenRecording_Android(),
            screenshot = Screenshot_Android()
        ),
        "IOS" to ScreenInit(
            startScreen_AppOne = StartScreen_AppOne_IOS(),
            screenRecording = ScreenRecording_IOS(),
            screenshot = Screenshot_IOS()

        )
    )
}