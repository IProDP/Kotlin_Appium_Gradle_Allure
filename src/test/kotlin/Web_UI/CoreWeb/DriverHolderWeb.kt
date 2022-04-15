package Web_UI.CoreWeb

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.edge.EdgeDriver


abstract class DriverHolderWeb {
    companion object {
        val jmindBaseURL: String = "https://jmind.systems/"

        val browser: String by lazy {
            System.getProperty("browser", "Chrome")
            //System.getenv("ENVIRONMENT") ?: "none"
        }
        val projectWeb: String by lazy {
            System.getProperty("projectWeb", "AppTwoWeb")
            //System.getenv("ENVIRONMENT") ?: "none"
        }
        val tagsWeb: String by lazy {
            System.getProperty("tagsWeb", "@Smoke")
            //System.getenv("ENVIRONMENT") ?: "none"
        }
        lateinit var driver: WebDriver

        fun getDriverWeb() {
            driver = when (browser) {
                "Chrome" -> {
                    val chromeOptions: ChromeOptions = ChromeOptions()
                    chromeOptions.addArguments("--start-maximized")
                    System.setProperty("webdriver.chrome.driver", "${System.getProperty("user.dir")}/resources/web_ui/web_drivers/Chrome/ChromeDriver100.0.4896.60/chromedriver.exe")
                    ChromeDriver(chromeOptions)
                }
                "Edge" -> {
                    System.setProperty("webdriver.edge.driver", "${System.getProperty("user.dir")}/resources/web_ui/web_drivers/Edge")
                    EdgeDriver()
                }
                else -> throw Exception("There is no such Environment!")
            }

        }
    }
}