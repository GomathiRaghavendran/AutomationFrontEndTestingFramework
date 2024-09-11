Automation Test Framework This project is a basic example of UI automation using Selenium WebDriver and TestNG for the ****** website.

Prerequisites Before you begin, ensure you have met the following requirements: Java Development Kit (JDK) installed (version 11.0.19). Maven installed. Chrome browser installed.

Clone the repository : git clone  https://github.com/GomathiRaghavendran/AutomationFrontEndTestingFramework

Set up Maven project: Ensure your pom.xml is configured to include the necessary dependencies for Selenium and TestNG. Version of Selenium 4.1.0 Version of testng 7.4.0

Running the Test Compile and run the test: You can compile and run the test using your IDE or using Maven from the command line: mvn test

Packages and its contents: Base: This package consists of code details to select which browser to launch the website url, loading the properties file and handling synchronisation issues by implementing waits.

Config: This package consists of information such as browser details, url and user credentials of the application to be tested.

Global resources: This package consists of methods and variables which are used to automate various functionalities throughout the framework

Utilities: This package consists information to store screenshot, reports in a defined location
