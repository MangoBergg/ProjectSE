Feature: Determine if start-and-end weeks of an activity updates as intended by method
  Description: Test if the start-and-end weeks of an activity changes in a chronological order and if the start-and-end
               weeks of the corresponding project are updated wrt. the earliest start week of all activities and the
               latest end week of all activities.
  Actor: Employee

  Scenario: Change start-and-end weeks when a project does not contain an activity
    Given a project "Project" exists
    When the project contains no activities
    Then the start-and-end weeks of an activity can not be updated
    And  the start-and-end weeks of the project can not be updated









#  Scenario: Attempting to set an end week before the start week
#    Given an activity exists with start week 10 and end week 12
#    When the employee attempts to change the start week to 15 and end week to 14
#    Then an error message "End week cannot be before start week" is given





#  Scenario: Activity is not contained in the project
#    Given a new project
#    And the project contains no activity
#    Then the method should return false
#
#  Scenario: Activity is contained in the project
#    Given a new project
#    And the project contains the activity "coding"
#    Then the method should return true