# GurukulaUiAutomation
This is a test automation project for Gurukula project where the user login and can create update and delete branch and staff details.

#Prerequisites:

Maven
Jdk 1.6 and above
#Getting started:

git clone https://github.com/sanchit097/GurukulaUiAutomation.git

Inside project go to GurukulaUiAutomation/resources/configuration/config.property

Provide the absolute driverPath example:'c:/drivers/chromeDriver.exe'(by default it will take the chrome driver path from project).

Provide the browser type in config.property file (chrome,firefox,internetexplorer).Default chrome is are selected.
provide the URL for the application running on your local server.

#Running the tests:

goto GurukulaUiAutomation folder
mvn clean test

#Test Result:
Cucumber test results can be seen in target/cucumber/index.html file.

Author
Sanchit Singh Negi
