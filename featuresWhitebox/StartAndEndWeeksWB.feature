Feature: Determine if start-and-end weeks of an activity updates as intended by method
  Description: Test if the start-and-end weeks of an activity changes in a chronological order and if the start-and-end
               weeks of the corresponding project are updated wrt. the earliest start week of all activities and the
               latest end week of all activities.
  Actor: Employee

  Scenario: 1(true), 3
    Given a project "Project" exists
    And it contains the activity "Activity"
    When the start week 4 is after the end week  2

  Scenario: 1(false), 2 (true), 4
    Given a project "Project" exists
    And it contains the activity "Activity"
    When the start week is 55 and the end week is 69

  Scenario: 1(false), 2 (false), 5
    Given a project "Project" exists
    And it contains the activity "Activity"
    When  the start-and-end weeks of the activity is set to start week 2 and end week 4
    Then the start-and-end weeks of the project is updated to start week 2 and end week 4






