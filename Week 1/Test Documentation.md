# Test Docs

## Test Plan
- A comprehensive document that covers how an application should be tested
- keep in mind the resources listed below can exist as their own documentation, or they can exist as part of the Test plan
    - Test Objectives
    - testing schedule
        - this can be its own resource
    - estimate details
        - how much will testing cost?
        - how much risk is involved?
    - deliverable expectations
        - test report expectations
        - test metrics expectations
        - build artifacts
- Ultimately, a test plan should be your central hub for checking testing requirements for the application you are working on

## Test Schedule
- this document holds the timeline for testing
    - deadlines
    - entry criteria & exit criteria
    - In an Agile environment, this is going to be a "living document"
        - "living document" == subject to change

## RTM
- This document used to be (and still can be if needed) an all-encompassing document. Requirements, User Stories, Test Cases, Test Result, all this and more used to be stored in the RTM. 
- it is a "traceability" document in that it was designed to allow for "tracing" or tracking work done on a requirement (think user story) throughout the entirety of a testing sprint
    - cloud and automated tools has made this unnecessary, but the RTM can always be used as a backup tool if things go wrong in the cloud
- this document is still a useful tool for initial organization of testing resources, particularly organizing user stories, requirements, acceptance criteria, and test data

## Software Requirements Specification
- This document provides details about the requirements of a system
    - functional requirements
        - functional requirements have to do with the features of an application
            - users should be able to log in
            - users should be able to register
            - add friends to their friend network
            - etc.
    - non-functional requirements
        - non-functional requirements have to do with the auxiliary needs of the application
            - application performance
                - how quickly does the application handle user requests?
            - data persistence
                - does the application accurately persist user data?
        - non-functional testing is often part of validating a company is meeting its Service Level Agreements (SLAs)
            - many cloud providers offer "guarantees" such as 99.9999 percent availability
            - Non-functional testing is performed by the cloud provider to make sure the service with this SLA actually meets the SLA

## Test Reports
- an overview of the results of your testing activities
    - can be an incremental progress report
    - final overall summary
- what was tested, test data used, results of tests, recommendations based off tests, etc.