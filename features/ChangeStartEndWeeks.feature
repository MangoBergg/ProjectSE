Feature: Change the start-and-end dates of an activity
  Description: Enables an employee to change the start-and-end weeks of an activity within a project, accommodating activities that initially do not have set weeks.
  Actor: Employee

  Scenario: Successfully changing start-and-end weeks to an activity
    Given an activity "Activity" exists
    When the employee changes the start week to 1 and end week to 2 for the activity
    Then the start and end weeks of the activity are updated to 1 and 2
    And the start and end weeks of the project containing the activity are updated to 1 and 2

  Scenario: Attempting to set an end week before the start week
    Given an activity exists with start week 10 and end week 12
    When the employee attempts to change the start week to 15 and end week to 14
    Then an error message "End week cannot be before start week" is given

  Scenario: Attempting to set an end week outside the range of a year
    Given an activity "Activity" exists
    When the employee attempts to change the start week to 0 and end week to 53
    Then an error message "The start and end weeks must be within a year (1-52)" is given