Feature: Determine if start-and-end weeks of an activity updates as intended by method
  Description: Test if the start-and-end weeks of an activity changes in a chronological order and if the start-and-end
               weeks of the corresponding project are updated wrt. the earliest start week of all activities and the
               latest end week of all activities.
  Actor: Employee

  Scenario: Fail to set the end week before the start week for an activity
    Given a project "Project" exists
    And it contains the activity "Activity"
    When the start week 4 is after the end week  2
    Then the error message "End week cannot be before start week" is given

  Scenario: Attempting to set an end week outside the range of a year
    Given a project "Project" exists
    And it contains the activity "Activity"
    When the start week is 55 and the end week is 69
    Then the error message "The start and end weeks must be within a year (1-52)" is given

  Scenario: Set the start-and-end weeks for an activity in a project
    Given a project "Project" exists
    And it contains the activity "Activity"
    When  the start-and-end weeks of the activity is set to start week 2 and end week 4
    Then the start-and-end weeks of the project is updated to start week 2 and end week 4






