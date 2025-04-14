# Cucumber Notes
Cucumber is a testing framework designed to link User Stories and their acceptance Criteria with executable Code

## Feature Files
Cucumber interperets Feature Files to determine what steps should be linked to what code. This is done through the use of Gherkin Syntax

### Feature
All feature files have a Feature that the steps/scenarios being tested are grouped under. Each feature file should have a single Feature. There is not a 1 to 1 connection between features and epics, but they are similar in purpose: they are both meant to be broad, overarching descriptors of their contained content

### Scenario
A specific explanation of an actor attempting to complete a User Story, which can be both positive and/or negative in nature. Here the similarity between the agile terminology and Gherkin syntax breaks down: Scenarios are not a 1 to 1 match with User Stories, but they can be direct references. It is the job of a tester to determine how a scenario (Gherkin key word) is related to the User Story it is testing

### Run Configurations
To execute your Cucumber Tests you need to provide Cucumber with 3 primary resources:
- Main class
    - What class is the entry point to start our tests
- Glue
    - Where is the code that is associated with your Feature steps
- Feature/Folder path
    - where are the feature files located

The steps you create can be reused across scenarios, but if you need a slight variation on their actions then you need to either create a new step or parameterize the step. Also keep in mind that scenarios will run from the top of the feature file to the bottom