@DEMO @WEB
Feature: demo

  Scenario: Web Demo
    Given I on the tapqa homepage
    When I click the "CAREERS LINK" in the global navbar
    Then I verify the "CAREERS HEADER" is displayed on the careers page
    And I verify the "KEYWORDS FILTER" is displayed on the careers page