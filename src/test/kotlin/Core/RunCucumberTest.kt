package Core

import io.cucumber.junit.CucumberOptions
import io.cucumber.junit.Cucumber
import org.junit.runner.RunWith


@RunWith(Cucumber::class)
@CucumberOptions(plugin = ["pretty","html:target/cucumber-report.html", "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"])
class RunCucumberTest

