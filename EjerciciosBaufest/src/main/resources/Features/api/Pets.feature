Feature: Add a new pet, get and modify an existing pet

  @wip
  Scenario: Add, get and modify a pet data
    Given I add a pet name "Rex" and photo link "https://images.app.goo.gl/3hDbXmQ1VPu2d2YFA" to the petstore
    And I get an existing pet
    When I modify the name of the pet to "Max"
    Then I should get status code 200