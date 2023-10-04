
Feature: First Page
  As a user, I should be able to reach first page

  Scenario: User search web site by URL
    Given correct url
    When user pass the correct url
    Then the title will be "Главная"
    And the url will match the url he entered

