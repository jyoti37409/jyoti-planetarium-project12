Feature: User Registration

  Scenario: Valid credential data should allow for registering with the Planetarium
    Given  the user is on the login page
    When   the user clicks the register link
    When   the user provides a valid username
    And    the user provides a valid password
    Then   an alert should appear saying "Account created successfully"
    And    the user should be redirected to the login page
