#Feature: Change the start-and-end dates of an activity
#  Description: Enables an employee to change the start-and-end weeks of an activity within a project, accommodating activities that initially do not have set weeks.
#  Actor: Employee
#
#  Scenario: Successfully assigning start-and-end weeks to an undated activity
#    Given an activity "Activity" exists without specific start-and-end weeks
#    When the employee assigns start and end week to the activity
#    Then the start and end weeks of the activity are updated
#    And the start and end weeks of the project containing the activity are updated








#  Scenario: Changing the start-and-end weeks of an activity with existing weeks Given the employee "huba" is logged into the system
#    And an activity "activity" exists with start week "1" and end week "3"
#    When the employee "huba" changes the start week to "2" and end week to "4" for "activity"
#    Then the start-and-end weeks of "activity" are updated to "2" and "4"
#    And the projects start-and-end weeks is adjusted to include the updated weeks of all activities
#
#  Scenario: Attempting to set an end week before the start week
#    Given the employee "huba" is logged into the system
#    And an activity "activity" exists with start week "10" and end week "12"
#    When the employee "huba" attempts to change the start week to "15" and end week to "14" for "activity"
#    Then an error message "End week cannot be before start week" is displayed