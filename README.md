# Kotlin_Appium_Gradle_Allure

##The goal of the project is to implement one common project in which it is possible:
1. Host several mobile Android and IOS applications and web application for projects with a common backend
2. Implement the setting of generating automatic reports on passed automatic application testing using Allure/Cucumber reporters. Which can be saved as a CI / CD artifact
3. Implement the addition of image attachments at a certain step (in case of unsuccessful passing of the step) and video about the passed test (in case of unsuccessful passing of the test)

##Behavior-Driven Development (BDD)
1. The approach will be implemented using the Cucumber framework
2. JUnit will be used to pass the implemented tests

##Mobile Application Testing
1. For testing mobile applications, *.apk files for the Android operating system and *.app for the iOS operating system will be used.
2. *.apk and *.app files can be delivered to the project thanks to CI/CD and moved to the resources/mobile_ui/ for apk or app folder
   1. *.app must be built in build mode "build for testing" with pre-selected simulator SDK and device version
   2. *.apk must be built with API support of the selected emulator model
3. Testing does not depend on the language in which the application is implemented
4. Emulator for Android and simulator for iOS are launched automatically by means of Appium "cappabilities"
5. For the convenience of communication between testers and developers, it is recommended to work with the development team on Kotlin