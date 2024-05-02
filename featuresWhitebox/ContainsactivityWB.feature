Feature: Project can determine if an activity is contained
  Description: Whitebox-test for the method containsActivity.

  Scenario: Activity is not contained in the project
    Given a new project
    And the project contains no activity
    Then the method should return false

  Scenario: Activity is contained in the project
    Given a new project
    And the project contains the activity "coding"
    Then the method should return true