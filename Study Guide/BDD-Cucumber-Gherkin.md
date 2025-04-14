# BDD-Gherkin-Cucumber Study Guide

## Behavior Driven Development

### BDD Intro
**Behavior Driven Development (BDD)** is the practice of performing development from the perspective of the end user. It takes into account the user experience, expectations, actions, and overall interaction with the application. This methodology emphasizes collaboration among developers, testers, and non-technical stakeholders to ensure that everyone has a shared understanding of the desired behavior of the application.

In **BDD**, the focus is on creating clear and concise specifications that describe how the application should behave in various scenarios. These specifications are often written in a natural language format that is easy for all team members to understand. This approach should influence the way the team thinks about all parts of the application, from the initial design to the final implementation. It encourages critically thinking about the user's journey and how each feature contributes to their overall satisfaction. By framing development tasks in terms of **User Stories** and **Acceptance Criteria**, **BDD** helps teams stay focused on the core features and requirements of the service being developed

### User Story
**User Stories** are structured to capture the perspective and needs of various types of users, such as customers, employees, new users, potential users, long-time users, etc. To create effective **User Stories**, a specific syntax is used to guide the process. Each **User Story** begins with the phrase **As a**, followed by the type of user, such as "customer," "employee," or "new user." This is followed by the phrase **I want**, which specifies the action the user wishes to perform, such as "to log in," "to log out," "to add a specific item to my shopping cart," "to scratch the furniture," etc. It is important to note that these **I want** statements should be specific when possible. The final part of the **user story** is the **So that** clause, which explains the reason or benefit behind the user's action. For example, "So that I can order my coffee," "So that I can save it for ordering later," or "So that I can get my owner to pay attention to me." This structure helps to ensure that each **User Story** is complete and provides a clear understanding of the user's goals and motivations. Some example **User Stories**:
- As a long-time customer, I want to register an account with my local coffee shop, so that I can earn rewards on my coffee purchases
- As a manager, I want to schedule employee shifts, so that the business is covered during all hours of operation
- As a cat, I want to scratch the furniture, so that my owner will pay attention to me

When creating **User Stories**, it is important to keep in mind the documentation will likely need to be changed or updated over time. Therefore, it is essential to use a tool that is flexible and allows for easy modifications to ensure that **User Story** information remains accurate and up-to-date

### Acceptance Criteria
Once **User Stories** are created (or at least the initial versions, as updates may be necessary), the next step is to define the steps the user must take in order to complete your **User Stories**. This is achieved through the use of **Acceptance Criteria**. **Acceptance Criteria** is a collection of actions the user takes to complete the **User Story**. These steps should be clear and specific, outlining the conditions that must be met for the **User Story** to be considered complete. These criteria help ensure that all team members have a shared understanding of what needs to be achieved and provide a foundation for creating tests

An example of **Acceptance Criteria** for a customer creating an account with a coffee shop:
- The customer can access the registration page from the coffee shop's website or app
- The registration form includes fields for name, email, password, and phone number
- The system sends a confirmation email upon successful registration
- The customer can log in using their email and password
- The customer can view their rewards balance and transaction history after logging in

## Cucumber Core Testing

### End to End Testing
**End-to-end (E2E)** testing involves validating that user actions can successfully complete **User Stories** by meeting the story's specified **Acceptance Criteria**, ensuring the system has the intended functionality and meets user needs. During **E2E** testing, **Acceptance Criteria** serve as the basis for test cases. Testers validate that each user action can be performed as described and that the system behaves as expected. By integrating **User Stories** and **Acceptance Criteria** into **E2E** testing, testers can comprehensively validate the system works as a whole, providing a seamless and functional user experience. This approach helps identify any gaps or issues that might not be apparent when testing individual components in isolation

### Cucumber Framework
**Cucumber** is a testing framework that can integrate **User Stories** and **Acceptance Criteria** into easily organized **E2E** tests. It makes use of plain language that can be understood by anyone working on the project (tester, developer, stakeholder, business analyst, marketing team, etc). At its core, **Cucumber** parses **Feature files** to determine the test **Scenarios** and then **maps the steps of those scenarios to executable code**. The parsing of data and mapping to executable code is facilitated through the plain text language **Gherkin**.

### Feature
**Cucumber** **Feature Files** provide a high-level description of a **User Story** or a group of related **User Stories**. They serve as blueprints for the behavior of the system from the user's perspective. Within the **feature file** the **Gherkin** keyword **Feature** should be used to label the contents of the file, and a description can be provided after the **Feature** declaration
```gherkin
Feature: User registration
    New users should be able to register with the coffee house
# File continues below
```

### Scenario
A **Cucumber** **Scenario** provides an explicit and direct description of a **User Story** being implemented. It outlines the specific steps and conditions under which the **User Story** is tested. **Scenarios** can represent both positive and negative tests, ensuring that the system behaves correctly when both paths are followed. Additionally, a **feature file** can contain multiple **Scenarios**, each addressing different aspects or variations of the **User Story**
```gherkin
Feature: User registration
    New users should be able to register with the coffee house

  Scenario: Users can register with valid User data
    # steps go here
  Scenario: Users can not register with invalid User data
    # steps go here
```

### Step Syntax
**Scenarios** in **Gherkin** use specific keywords to organize their acceptance criteria steps. The keyword **Given** indicates a starting point or precondition for executing the **Acceptance Criteria**. **When** represents an action that must be taken to complete the **Scenario**. **Then** describes the intended outcome of completing the **Acceptance Criteria** and should be written as normative statements, such as "Then the user should be registered with the coffee house." The keywords **And** and **But** can be used in place of **Given**, **When**, or **Then** when multiple steps of the same type occur in a row, making the steps easier to read. Additionally, a star icon **\*** can be used in place of any of the step keywords. Keep in mind these distinctions are purely syntax for the human reader: **Cucumber** makes no distinction of the intent between these step keywords. As far as the framework is concerned, these keywords simply indicate a new step has been reached in the **Scenario**
```gherkin
Feature: User registration
    New users should be able to register with the coffee house

  Scenario: Users can register with valid User data
    Given   the user is on the register page
    When    the user enters valid credentials
    Then    the user should be registered with the coffee house

  Scenario: Users can not register with invalid User data
    Given   the user is on the register page
    When    the user enters invalid credentials
    Then    the user should be notified the credentials are invalid
```

These steps are meant to be modular: instead of creating new steps for each scenario you can reuse steps that perform similar actions, when possible. To accommodate the need for new data in different runs you can have **Cucumber** inject your test data at runtime
```gherkin
  Scenario: Users can register with valid User data
    Given   the user is on the register page
    When    the user enters username "Javal1fe" and password "soSecur3"
    Then    the user should be told "account created successfully"

  Scenario: Users can not register with invalid User data
    Given   the user is on the register page
    When    the user enters username "invalid" and password "not secure"
    Then    the user should be told "account creation failed"
```
the syntax above tells **Cucumber** the String values need to be inject to the associated step methods. To link a method with a step the associated method is annotated with a step provided by **Cucumber**

```java
/*
    the three methods below are linked to the six steps written above: for each scenario, if there is any data that is unique to the
    scenario and the step in that scenario, Cucumber will provide it at run time. Note that which annotation you use is programatically irrelevant: the only benefit of matching the annotation with the step type is to make it clearer to the reader what step is being handled by the method. The @And annotation could be used for all three of these methods, and Cucumber would still match them correctly. This is 
    because the text of the step is used by Cucumber to match the step with the method, the Gherkin keyword simply tells the framework a new
    step has been reached
 */

@Given("the user is on the register page")
public void starting_step() {
    // setup is handled here
}

@When("the user enters username {string} and password {string}")
public void action_step(String username, String password) {
    // attempt to create account is handled here
}

@Then("the user should be told {string}")
public void result_step(String result) {
    // validation of results is handled here
}
```
By parameterizing your steps you can reuse them, cutting down on the total number of steps you need to implement. **Cucumber** has 11 different types it supports by default (taken from Cucumber documentation):
| Parameter Type  | Description |
| --------------- | ----------- |
| `{int}`         | Matches integers, for example `71` or `-19`. Converts to a 32-bit signed integer if the platform supports it.|
| `{float}`       | Matches floats, for example `3.6`, `.8` or `-9.2`. Converts to a 32 bit float if the platform supports it. |
| `{word}`        | Matches words without whitespace, for example `banana` (but not `banana split`). |
| `{string}`      | Matches single-quoted or double-quoted strings, for example `"banana split"` or `'banana split'` (but not `banana split`). Only the text between the quotes will be extracted. The quotes themselves are discarded. Empty pairs of quotes are valid and will be matched and passed to step code as empty strings. |
| `{}` anonymous  | Matches anything (`/.*/`). |
| `{bigdecimal}`  | Matches the same as `{float}`, but converts to a `BigDecimal` if the platform supports it. |
| `{double}`      | Matches the same as `{float}`, but converts to a 64 bit float if the platform supports it. |
| `{biginteger}`  | Matches the same as `{int}`, but converts to a `BigInteger` if the platform supports it. |
| `{byte}`        | Matches the same as `{int}`, but converts to an 8 bit signed integer if the platform supports it. |
| `{short}`       | Matches the same as `{int}`, but converts to a 16 bit signed integer if the platform supports it. |
| `{long}`        | Matches the same as `{int}`, but converts to a 64 bit signed integer if the platform supports it. |

### Cucumber Options
**Cucumber** requires specific configuration information to function correctly. The "features" configuration specifies where the **feature files** are located, which can include directories and individual files. If no feature file information is provided, **Cucumber** will scan the entire project for files. The "glue" configuration indicates where the code implementation of the **Scenario** steps are located, targeting packages and individual classes. Similarly, if no glue information is provided, **Cucumber** will scan the entire project for files. Although not technically required, "plugins" can be used to enhance tests and test reports. For example, the "pretty" plugin makes the CLI readout of test results easier to read, while the "html" plugin generates an HTML test report at the specified location

### Executing Tests
To execute **Cucumber** tests, you have several options. If you are using a Cucumber/Gherkin plugin in your IDE, you can "execute" your **feature files** directly. Alternatively, you can create a test runner and facilitate test execution through the runner class. Another method is to use the "test" or "verify" Maven commands to trigger your tests

Note that if you have missing step implementations for your **feature files** suggested step methods will be generated for you: these can be used to jump-start creating the implementation steps for your tests
