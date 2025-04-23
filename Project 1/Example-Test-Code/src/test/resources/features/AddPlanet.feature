Feature: Add Planet

  Background:
    Given the user is on the planetarium homepage and selects Planet

  Scenario: Valid user should add the planet successfully
    When the user provides a valid planet name "Mercury"
    Then the planet name "Mercury" should be saved on the Planetarium Home Page

  Scenario: Valid user should add a planet with image
    Given the user is on the planetarium homepage and selects Planet
    When the user provides a valid planet name "Testdone12" and image path "C:\\Users\\havisha\\Downloads\\jupiter.jpg"
    Then the planet name "Testdone12" should be saved on the Planetarium Home Page
