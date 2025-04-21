Feature: Secure login to access the Planetarium
  As a user
  I want to securely access my account
  So I can interact with the Planetarium in a secure environment

  Scenario: Successful login with valid credentials
    Given the user is on the login page
    When the user provides a valid username "Batman" while login
    And the user provides a valid password "Iamthenight1939" while login
    When the user clicks the "login" button
    Then the user should be redirected to the Planetarium home page


  Scenario: Failed login with invalid credentials
    Given the user is on the login page
    When the user enters an invalid "John" or "s12"
    And clicks the "Login" button
    Then the user should see an error message "Invalid credentials"
    And the user should remain on the login page