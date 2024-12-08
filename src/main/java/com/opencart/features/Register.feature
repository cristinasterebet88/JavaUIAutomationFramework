Feature: The register Flow test suite

  @run
  Scenario: The user is redirected to the Account page after successful registration
    Given The "https://tekwillacademy-opencart.online/" is accessed
    And RegisterPage is accessed from HomePage buttons
    When the registration form is populated with valid random data
    And the privacyPolicyToggle is enabled
    And continueButton is clicked
    Then the new page url contains "success" keyword

  @run
  Scenario: The system keeps the user on the Registration when registering with valid data without accepting Privacy Rules
    Given The "https://tekwillacademy-opencart.online/" is accessed
    And RegisterPage is accessed from HomePage buttons
    When the registration form is populated with valid random data
    And continueButton is clicked
    Then the new page url contains "register" keyword

  @run
  Scenario Outline: Error message is displayed when registering with invalid password length
    Given The "https://tekwillacademy-opencart.online/" is accessed
    And RegisterPage is accessed from HomePage buttons
    And the register form is populated as follows:
      | firstName | <firstName> |
      | lastName  | <lastName>  |
      | email     | RANDOM      |
      | password  | <password>  |
    And a thread sleep 5 seconds is executed
    When continueButton is clicked
    Then the following list of error messages is displayed:
      | <errorFieldName> must be between <min> and <max> characters! |
      | Warning: You must agree to the Privacy Policy!               |
    Examples:
      | firstName | lastName                                    | password                                           | errorFieldName | min | max |
      | Random    | Secu                                        | 321                                                | Password       | 4   | 20  |
      | Random    | Secu                                        | 12345678901234567890123456789012345678901234567890 | Password       | 4   | 20  |
      | Random    | 1234567890123456789012345678901234567890123 | 12345678901234567890123                            | Last Name      | 1   | 32  |