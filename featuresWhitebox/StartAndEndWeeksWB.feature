Feature: Determine if start-and-end weeks of an activity updates as intended by method
  Description: Test if the start-and-end weeks of an activity changes in a chronological order and if the start-and-end
               weeks of the corresponding project are updated wrt. the earliest start week of all activities and the
               latest end week of all activities.
  Actor: Employee

  Scenario: A project does not have start-and-end weeks when it does not contain an activity
    Given a project "Project" exists
    When the project does not contain an activity
    Then the project does not have start-and-end weeks


  Scenario: Set the start-and-end weeks for the first activity in a project
    Given a project "Project" exists
    And the project contains only the activity "Activity"
    When  the start-and-end weeks of the activity is set to start week 12 and end week 15
    Then the start-and-end weeks of the project is updated to start week 12 and end week 15


  Scenario: Update start-and-end weeks wrt. earliest and latest activities
    Given a project "Project" exists
    When the second activity "Programming" is created in the project
    And the start-and-end weeks of the new activity is set to start week 11 and end week 20
    Then the start-and-end weeks of the project is updated to begin at the earliest start week 11 and end at the latest end week 20


#  Scenario: Fail to set the end week before the start week for an activity
#    Given the project "Project" contains the activity "Activity"
#    When the end week is set to 25 and the start week is set to 18
#    Then the error message "End week cannot be before start week" is given



