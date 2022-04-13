package Core

import Core.DriverHolder.Companion.driver
import Core.DriverHolder.Companion.environment
import Core.DriverHolder.Companion.project
import Core.DriverHolder.Companion.tags
import Core.ProjectCapabilities.Companion.deviceName
import Core.ProjectCapabilities.Companion.platformVersion
import Core.ProjectCapabilities.Companion.udid
import com.google.common.collect.ImmutableMap
import io.qameta.allure.Attachment
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.w3c.dom.Document
import org.w3c.dom.Element
import java.io.File
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.text.SimpleDateFormat
import java.util.*
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.parsers.ParserConfigurationException
import javax.xml.transform.Transformer
import javax.xml.transform.TransformerException
import javax.xml.transform.TransformerFactory
import javax.xml.transform.dom.DOMSource
import javax.xml.transform.stream.StreamResult


abstract class AllureReport() {
    companion object {
        fun allureEnvironmentWriter(environmentValuesSet: ImmutableMap<String?, String?>, customResultsPath: String) {
            try {
                val docFactory = DocumentBuilderFactory.newInstance()
                val docBuilder = docFactory.newDocumentBuilder()
                val doc: Document = docBuilder.newDocument()
                val environment: Element = doc.createElement("environment")
                doc.appendChild(environment)
                environmentValuesSet.forEach { (k: String?, v: String?) ->
                    val parameter: Element = doc.createElement("parameter")
                    val key: Element = doc.createElement("key")
                    val value: Element = doc.createElement("value")
                    key.appendChild(doc.createTextNode(k))
                    value.appendChild(doc.createTextNode(v))
                    parameter.appendChild(key)
                    parameter.appendChild(value)
                    environment.appendChild(parameter)
                }

                // write the content into xml file
                val transformerFactory = TransformerFactory.newInstance()
                val transformer: Transformer = transformerFactory.newTransformer()
                val source = DOMSource(doc)
                val allureResultsDir = File(customResultsPath)
                if (!allureResultsDir.exists()) allureResultsDir.mkdirs()
                val result = StreamResult(
                    File(customResultsPath + "environment.xml")
                )
                transformer.transform(source, result)
                println("Allure environment data saved.")
            } catch (pce: ParserConfigurationException) {
                pce.printStackTrace()
            } catch (tfe: TransformerException) {
                tfe.printStackTrace()
            }
        }

        fun setAllureEnvironment() {
            allureEnvironmentWriter(
                ImmutableMap.builder<String, String>()
                    .put("OS:", System.getProperty("os.name"))
                    //.put("Java version:", System.getProperty("java.version"))
                    .put("Platform:", environment + " Version: "+ platformVersion)
                    .put("Device:", deviceName +" UDID: " + udid)
                    .put("Project:", project + " Tags: " + tags)
                    .build(), System.getProperty("user.dir") + "/build/allure-results/"
            )
        }
        @Attachment(value = "Page screenshot", type = "image/png", fileExtension = ".png")
        fun saveScreenshot(): File? {
            val file = (driver as TakesScreenshot).getScreenshotAs(OutputType.FILE)
            return file
        }

        @Attachment(value = "Page screenshot", type = "video/mp4", fileExtension = ".mp4")
        fun saveVideo(videoStream: ByteArray?): File {
            fun Date.toString(format: String, locale: Locale = Locale.getDefault()): String {
                val formatter = SimpleDateFormat(format, locale)
                return formatter.format(this)
            }
            val dateInString = Calendar.getInstance().time.toString("yyyy.MM.dd-HH.mm.ss")

            val path: Path = Paths.get(System.getProperty("user.dir") + "artifact/video/$dateInString.mp4")
            return Files.write(path, videoStream).toFile()
        }
    }
}

