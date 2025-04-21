Feature: Add Moon

  Background:
    Given the user is on the planetarium homepage and selects Moon

  Scenario: Valid user should add the planet successfully
    When the user provides a valid moon name "MoonTest2" and planet ID "1"
    Then the moon name should be saved on the Planetarium Home Page



