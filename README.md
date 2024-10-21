# LUMA E-Commerce UI Automation
This project automates UI testing for the Luma theme in Magento using a Cucumber BDD framework with JUnit, Java, and Maven

## Table of Contents
 - Project Overview
 - Technologies Used
 - Setup and Installation
 - Running the Tests
 - Project Structure
 - Contributing
 - License

## Project Overview
This project is aimed at automating the user interface of the Magento-based Luma eCommerce store. It leverages the Cucumber BDD framework to write tests in a human-readable format, using Gherkin syntax, while ensuring integration with JUnit for test execution and Maven for project management.

### Key Features:
- UI automation for Magento's Luma theme.
- Implementation of BDD with Cucumber.
- Cross-browser testing.
- Continuous integration support with Maven and JUnit.

## Technologies Used
- **Java**: Programming language for the test logic.
- **Cucumber**: BDD framework used for writing test scenarios in Gherkin.
- **JUnit for Assertions**: Provides a rich set of assertions to verify Cucumber tests outcomes.
- **Selenium WebDriver**: Automates browser interactions for UI testing.
- **Page Object Model (POM)**: Promotes a clean separation between test logic and page elements.
- **Maven**: Manages dependencies and build processes effectively.

## Setup and Installation

### Perequisites
Before you begin, ensure you have the following installed on your local machine:
- IDE: Use an IDE like IntelliJ IDEA (or Eclipse)
- Java JDK 8 or above
- Maven
- Selenium WebDriver
- JUnit
- Cucumber
- SLF4J (for logging)

### Installation Steps
#### 1. Clone the repository:
```sh
git clone [git-url]
cd checkout_[your-feature-branch]
```
#### 2. To build the project, run:
```sh 
mvn clean install
```
#### 3. Set up your Magento account:
- Visit https://magento.softwaretestingboard.com/ and create your own account.
- Make note of your username and password, as you will use these for testing.

#### 4. Set environment variables for credentials in IntelliJ:

- Open your project in IntelliJ IDEA.
- Go to Run > Edit Configurations.
- Under your test configuration (JUnit or Maven), add environment variables:
    - username: Your Magento username.
    - password: Your Magento password.
* Example: 
```sh 
username=your_username
password=your_password
```

## Runing the Tests
### Run Tests via Maven
You can run all the Cucumber tests using the following Maven command:
```sh 
mvn test 
or 
mvn test -Dcucumber.options="--tags @Login"
```
Also tests can be run through *CukesRunner.class*

## Project Structure
The project follows a typical Maven project structure.

```sh 
src
│
├── main
│   └── java
│       └── resources          
             └── log4j2.xml    # For logging purposes
│
└── test
    ├── java
    │   ├── pages              # Page Object Models for the UI components.
    │   ├── runner             # Test runners using JUnit.
    │   ├── step_definitions   # Step definitions for Cucumber scenarios.
    │   └── utilities              
    │
    └── resources
        └── features             # Feature files written in Gherkin syntax.
Configuration.properties         # Configuration file for storing variables
pom.xml                          # Maven project configuration file
README.md                        # Project documentation
```


