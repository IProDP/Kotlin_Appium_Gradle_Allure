package Mobile_UI.AppOneScreenInit

import Mobile_UI.AppOneScreenInit.POM.*
import Core.DriverHolder.Companion.environment


object ScreenInitilazer_AppOne {

    data class ScreenInit(
        val startScreen_AppOne: StartScreen_AppOne
    )

    val startScreen by lazy {
        screens[environment]!!.startScreen_AppOne
    }

    private val screens = mapOf(
        "Android" to ScreenInit(
            startScreen_AppOne = StartScreen_AppOne_Android()
        ),
        "IOS" to ScreenInit(
            startScreen_AppOne = StartScreen_AppOne_IOS()

        )
    )
}