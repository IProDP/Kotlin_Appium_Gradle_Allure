package Web_UI.AppOneWeb

import Web_UI.AppOneWeb.POM.*
import Web_UI.CoreWeb.DriverHolderWeb.Companion.browser


object ScreenInitilazer_AppOneWeb {

    data class ScreenInit(
        val homePage: HomePage,
    )

    val homePage by lazy {
        screens[browser]!!.homePage
    }


    private val screens = mapOf(
        "Chrome" to ScreenInit(
            homePage = HomePage()

        ),
        "Edge" to ScreenInit(
            homePage = HomePage()
        )
    )
}