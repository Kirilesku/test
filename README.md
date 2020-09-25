
# Test - QA Automatisation test 


## Introduction

This project is built on top of Selenium WebDriver API. Automated tests are written in Java. Test should be run using TestNG xml.



## Prerequisites

There are a couple of  prerequisites that will be necessary in order to start using the project.

* **Java** - This project was written using Java. Visit [the official Oracle page](https://www.oracle.com/technetwork/java/javase/downloads/jdk12-downloads-5295953.html) in order to download the development kit.
* **Maven** - This project relies on Maven for package management and project building. Make sure that your IDE of choice supports Maven, that it is [downloaded](https://maven.apache.org/) and installed..



## Structure

The key features of this framework will be listed below in no particular order. Understanding the logic behind these features will make using the framework much more fluid.



### Enviroment configuration

Enviroment could be changed in "AddEmployeeScenario.xml" file by changing 'env' parameter. Curently there is three parameters and those are: staging, develop and prod. The logic and links to enviroments are defined in "Base.java" file.



### Browser configuration

Browser could be changed in "AddEmployeeScenario.xml" file by changing 'browser' parameter. Curently there is two parameters and those are: chrome and firefox. The logic are defined in "Base.java" file.


#### Reporting

Reports for every run of AddEmployeeScenario.xml suite are stored in "reports" folder in root of the project. 


