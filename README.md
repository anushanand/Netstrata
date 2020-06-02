# Domain Test Framework
This is a reusable automated test framework that can be used to write test scripts for a web application.
The scripts can be run on multiple browsers, and can be run in serial or parallel execution mode. At this point, it supports Chrome and Firefox.
It uses Selenium WebDriver and testNG and is written in Java.
The framework follows the Page Object Model for easier maintenance and re-usability.

## Pre-requisites
JDK 1.8
Maven 3.3.9

## Setting up
1. Load the project into an IDE.
2. Go to the file "VerifySearch.java" in the tests folder (path: /netstrata/src/test/java/Tests/VerifySearch.java)
3. Update the parameter "/path/to/chromedriver" with your complete path to chromedriver (relative path: /netstrata/chromedriver)
4. Update the parameter "/path/to/geckodriver" with your complete path to geckodriver (relative path: /netstrata/geckodriver)

## Running the tests in serial mode.
1. Open the TestNG.xml file.
2. Update the value for parallel to 'none' in the line 'suite name="TestSuite" thread-count="2" parallel="***"'.
3. Run the TestNG.xml file.

## Running the tests in parallel mode.
1. Open the TestNG.xml file.
2. Update the value for parallel to 'tests' in the line 'suite name="TestSuite" thread-count="2" parallel="***"'.
3. Run the TestNG.xml file.

## Reporting
After the run is complete, reports will be generated under a test-output folder.
Open the emailable-report.html in a browser of your choice to view the report (path: /netstrata/test-output/emailable-report.html)