Feature: Creating an user - login/logout

  @wip
  Scenario: Signing up new user
    Given I enter the web "https://www.demoblaze.com/"
    And I chose the option "Sign up"
    And I set the username "admin111" and password "admin100"
    When I click the button "Sign up"
    Then I should see the message "Sign up successful."

  @wip
  Scenario: Log-in and log-out user
    Given I am already log in
    When I chose the option "Log out"
    Then I should see the menu option "Sign up"