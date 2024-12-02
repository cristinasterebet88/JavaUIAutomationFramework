Feature: The register Flow test suite

  @run
  Scenario: The user is redirected to the Account page after successful registration
    Given The Home page is displayed
    And RegisterPage is accessed from HomePage buttons
    When the registration form is populated with valid random data
    And the privacyPolicyToggle is enabled
    And continueButton is clicked
    Then the new page url contains "success" keyword

  @run
  Scenario: The system keeps the user on the Registration when registering with valid data without accepting Privacy Rules
    Given The Home page is displayed
    And RegisterPage is accessed from HomePage buttons
    When the registration form is populated with valid random data
    And continueButton is clicked
    Then the new page url contains "register" keyword