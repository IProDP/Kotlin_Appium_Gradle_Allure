package Web_UI.AppOneWeb.POM

import Mobile_UI.AppTwoPageFactory.POM.Page
import Web_UI.CoreWeb.DriverHolderWeb.Companion.driver
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.pagefactory.FieldDecorator

class HomePage() {


    init {
        PageFactory.initElements(driver, this)
    }

    @FindBy(xpath = "//*[@id=\"__next\"]/section[2]/div/div[1]/h1/span")
    var jmind: WebElement? = null

    @FindBy(xpath = "/html/body/div[3]/section[1]/div/div/nav/a[1]")
    var aboutUs: WebElement? = null

    fun isTextTitleJMINDVisible(): Boolean {
        return jmind?.isDisplayed!!
    }

    fun textTitleJMIND(): String {
        return jmind?.getAttribute("text")!!
    }

    fun isAboutUsVisible(): Boolean {
        return aboutUs?.isDisplayed!!
    }

    fun textTitleAboutUs(): String {
        return aboutUs?.getAttribute("text")!!
    }
    fun clickAboutUsBtn (): HomePage {
        aboutUs?.click()
        return this
    }
}


