package Core

import Core.DriverHolder.Companion.environment
import Core.DriverHolder.Companion.project

class KeyPaths {
        companion object {
                lateinit var folder: String
                lateinit var typeApp: String
                lateinit var nameOfOS: String

                fun pathToAppiumMainJs(): String{
                        nameOfOS = System.getProperty("os.name").toLowerCase()
                        if(nameOfOS.indexOf("win") >= 0){
                                return "${System.getProperty("user.home")}/AppData/Roaming/npm/node_modules/appium/build/lib/main.js"
                        }
                        else if (nameOfOS.indexOf("mac") >= 0){
                                return "${System.getProperty("user.home")}/node_modules/appium/build/lib/main.js"
                        }
                        else {
                                throw Exception("There is no such OS type in Appium Environment")
                        }
               }

                fun pathToNodejs(): String{
                        nameOfOS = System.getProperty("os.name").toLowerCase()
                        if(nameOfOS.indexOf("win") >= 0){
                                return "C:\\Program Files\\nodejs\\node.exe"
                        }
                        else if (nameOfOS.indexOf("mac") >= 0){
                                return "/usr/local/bin/node"
                        }
                        else {
                                throw Exception("There is no such NODE path")
                        }
                }

                fun Path():String {
                        if (environment == "Android"){
                                typeApp = "apk"
                                when (project.toString()) {
                                        "AppOne_Device" -> folder = "mobile_ui/AppOne/$typeApp/app-release.apk"
                                        "AppOne_Emulator" -> folder = "mobile_ui/AppOne/$typeApp/app-release.apk"
                                        "AppTwo_Device" -> folder = "mobile_ui/AppTwo/$typeApp/app-release.apk"
                                        "AppTwo_Emulator" -> folder = "mobile_ui/AppTwo/$typeApp/app-release.apk"
                                }
                        } else if (environment == "IOS") {
                                typeApp = "app"
                                when (project.toString()) {
                                        "AppOne_Device" -> folder = "mobile_ui/AppOne/$typeApp/app-release.app"
                                        "AppOne_Emulator" -> folder = "mobile_ui/AppOne/$typeApp/app-release.app"
                                        "AppTwo_Device" -> folder = "mobile_ui/AppTwo/$typeApp/app-release.app"
                                        "AppTwo_Emulator" -> folder = "mobile_ui/AppTwo/$typeApp/app-release.app"
                                }
                        }
                        return "${System.getProperty("user.dir")}/resources/$folder"
                        }
        }
}


