Feature: Login related tests

  @run
  Scenario Outline: An error message is displayed when trying to log in with invalid details
    Given The "/index.php?route=account/login&language=en-gb" endpoint is accessed
    And the login form is populated with the following data:
      | <email>    |
      | <password> |
    When the "loginBtn" from "LoginPage" is clicked
    Then the following list of error messages is displayed:
      | Warning: No match for E-Mail Address and/or Password. |
    Examples:
      | email           | password |
      | email@gmail.com | data123! |
      | email@gmail.com | !        |