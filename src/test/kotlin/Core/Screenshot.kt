package Core

import Core.DriverHolder.Companion.driver
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.testcontainers.shaded.org.apache.commons.io.FileUtils
import java.io.File
import java.text.SimpleDateFormat
import java.util.*


abstract class Screenshot() {

    abstract fun _takeScreenShot(nameOfMethod: String): File
}

class Screenshot_Android: Screenshot() {

    override fun _takeScreenShot(nameOfMethod: String) : File //= (driver as TakesScreenshot).getScreenshotAs(OutputType.FILE)
    {
        fun Date.toString(format: String, locale: Locale = Locale.getDefault()): String {
            val formatter = SimpleDateFormat(format, locale)
            return formatter.format(this)
        }
        val dateInString = Calendar.getInstance().time.toString("yyyy.MM.dd-HH.mm.ss")

        val file = (driver as TakesScreenshot).getScreenshotAs(OutputType.FILE)
        FileUtils.copyFile(file, File("${System.getProperty("user.dir")}/screenshot/${dateInString}-${nameOfMethod}.png"))
        return file
    }
}
class Screenshot_IOS: Screenshot(){
    override fun _takeScreenShot(nameOfMethod: String) : File
    {
        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        val currentDate = sdf.format(Date())

        val file = (driver as TakesScreenshot).getScreenshotAs(OutputType.FILE)
        FileUtils.copyFile(file, File("${System.getProperty("user.dir")}/screenshot/"+ nameOfMethod + currentDate  +".jpg"))
        return file
    }
}

