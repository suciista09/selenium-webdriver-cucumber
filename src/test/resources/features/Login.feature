Feature:

  Scenario Outline:
    Given I am in login page
    When I input correct email: "<email>"
    And I input correct password : "<password>"
    And I click login button
    Then I logged in

    Examples:
    |email|password|
    |     test@gmail.com|password123|