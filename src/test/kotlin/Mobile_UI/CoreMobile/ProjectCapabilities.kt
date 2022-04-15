package Mobile_UI.CoreMobile

import Mobile_UI.CoreMobile.DriverHolder.Companion.project
import org.openqa.selenium.remote.DesiredCapabilities
import Mobile_UI.CoreMobile.KeyPaths.Companion.Path


class ProjectCapabilities {


    companion object {
        lateinit var platformName: String
        lateinit var deviceName: String
        lateinit var platformVersion: String
        lateinit var udid: String
        lateinit var automationName: String

        fun BaseCapabilities(environment:String): DesiredCapabilities {
            val caps = DesiredCapabilities()

            when (environment) {
                "Android" -> {
                    platformName = environment
                    deviceName = "Pixel_2_API_29"
                    platformVersion = "9"
                    udid = "emulator-5554"
                    automationName = "UiAutomator2"
                }
                "IOS" -> {
                    platformName = environment
                    deviceName = "iPhone 12"
                    platformVersion = "15.2"
                    udid = "SimulatorDeviceUdid"
                    automationName = "XCUITest"
                }
                else -> throw Exception("There is no such Capabilities!")
            }
            when(project.toString())
            {
            "AppOne_Emulator" -> {
                if (environment == "Android") {
                    caps.setCapability("avd", deviceName)
                    caps.setCapability("app", Path())
                    caps.setCapability("platformName", platformName)
                    caps.setCapability("platformVersion", platformVersion)
                    caps.setCapability("automationName", "UiAutomator2")
                    caps.setCapability("deviceName", deviceName)
                    caps.setCapability("udid", udid)
                    caps.setCapability("appPackage", "com.jmindsystems.blend")
                    caps.setCapability("appActivity", ".MainActivity")
                    caps.setCapability("autoGrantPermissions", "true")
                    //caps.setCapability("noReset", true)
                    //caps.setCapability("skipUnlock", "false")
            } else {
                    caps.setCapability("app", Path())
                    caps.setCapability("platformName", platformName)
                    caps.setCapability("platformVersion", platformVersion)
                    caps.setCapability("automationName", "XCUITest")
                    caps.setCapability("deviceName", deviceName)
                    caps.setCapability("udid", udid)
                    caps.setCapability("bundleId", "PLACEHOLDER")
                    caps.setCapability("wdaStartupRetries", "4")
                    caps.setCapability("iosInstallPause", "8000")
                    caps.setCapability("wdaStartupRetryInterval", "20000")
                    caps.setCapability("autoAcceptAlerts", "true")
                }
            }
            "AppOne_Device" -> {
                if (environment == "Android") {
                    caps.setCapability("app", Path())
                    caps.setCapability("platformName", platformName)
                    caps.setCapability("platformVersion", platformVersion)
                    caps.setCapability("automationName", "UiAutomator2")
                    caps.setCapability("deviceName", "PLACEHOLDER")
                    caps.setCapability("udid", "PLACEHOLDER")
                    caps.setCapability("appPackage", "com.jmindsystems.blend")
                    caps.setCapability("appActivity", ".MainActivity")
                    caps.setCapability("autoGrantPermissions", true)
                    caps.setCapability("autoAcceptAlerts", true)

                } else {
                    caps.setCapability("app", Path())
                    caps.setCapability("platformName", "IOS")
                    caps.setCapability("platformVersion", platformVersion)
                    caps.setCapability("automationName", "XCUITest")
                    caps.setCapability("deviceName", "PLACEHOLDER")
                    caps.setCapability("udid", "PLACEHOLDER")
                    caps.setCapability("appPackage", "com.jmindsystems.blend")
                    caps.setCapability("appActivity", ".GardenActivity")
                }
            }
            "AppTwo_Emulator" -> {
                if (environment == "Android") {
                    caps.setCapability("avd", deviceName)
                    caps.setCapability("app", Path())
                    caps.setCapability("platformName", platformName)
                    caps.setCapability("platformVersion", platformVersion)
                    caps.setCapability("automationName", "UiAutomator2")
                    caps.setCapability("deviceName", deviceName)
                    caps.setCapability("udid", udid)
                    caps.setCapability("appPackage", "com.jmindsystems.blend")
                    caps.setCapability("appActivity", ".MainActivity")
                    caps.setCapability("autoGrantPermissions", "true")
                    //caps.setCapability("noReset", true)
                    //caps.setCapability("skipUnlock", "false")
                } else {
                    caps.setCapability("app", Path())
                    caps.setCapability("platformName", platformName)
                    caps.setCapability("platformVersion", platformVersion)
                    caps.setCapability("automationName", "XCUITest")
                    caps.setCapability("deviceName", deviceName)
                    caps.setCapability("udid", udid)
                    caps.setCapability("bundleId", "PLACEHOLDER")
                    caps.setCapability("wdaStartupRetries", "4")
                    caps.setCapability("iosInstallPause", "8000")
                    caps.setCapability("wdaStartupRetryInterval", "20000")
                    caps.setCapability("autoAcceptAlerts", "true")
                    }
                }
            "AppTwo_Device" -> {
                if (environment == "Android") {
                    caps.setCapability("app", Path())
                    caps.setCapability("platformName", platformName)
                    caps.setCapability("platformVersion", platformVersion)
                    caps.setCapability("automationName", "UiAutomator2")
                    caps.setCapability("deviceName", "PLACEHOLDER")
                    caps.setCapability("udid", "PLACEHOLDER")
                    caps.setCapability("appPackage", "com.jmindsystems.blend")
                    caps.setCapability("appActivity", ".MainActivity")
                    caps.setCapability("autoGrantPermissions", true)
                    caps.setCapability("autoAcceptAlerts", true)
                } else {
                    caps.setCapability("app", Path())
                    caps.setCapability("platformName", "IOS")
                    caps.setCapability("platformVersion", platformVersion)
                    caps.setCapability("automationName", "XCUITest")
                    caps.setCapability("deviceName", "PLACEHOLDER")
                    caps.setCapability("udid", "PLACEHOLDER")
                    caps.setCapability("appPackage", "PLACEHOLDER")
                    caps.setCapability("appActivity", ".GardenActivity")
                }
            }
            }
return caps
}
}
}