Feature: Add Moon

  Background:
    Given the user is on the planetarium homepage and selects Moon

  Scenario: Valid user should add the moon successfully
    When the user provides a valid moon name "MoonTest3" and planet ID 1
    Then the moon name "MoonTest3" should be saved on the Planetarium Home Page

  Scenario: Valid user should add a moon with image
    When the user provides a valid moon name "MoonTest2" and planet ID 1 and image "C:/temp/pluto.jpg"
    Then the moon name "MoonTest2" should be saved on the Planetarium Home Page

  Scenario: Invalid moon name should trigger alert
    When the user provides a valid moon name "@@@@!!" and planet ID 1
    Then an alert should appear saying "Invalid moon name"



