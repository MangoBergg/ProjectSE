Feature: Register time consumption
  Description: An employee registers time consumed on an activity
  Actor: Employee

  Scenario: Successfully registering time consumed on an activity which an employee is assigned to
    Given the employee "huba" is assigned to the activity "Activity" in the project "Project"
    When the employee registers consumed time as 5.0 hours on the activity
    Then the consumed time on the activity is updated by adding 5.0 hours
    #And the working hours of the employee "huba" is updated


  #the employee attempts to assign an employee "employee ID" to the activity "Activity" in the project "Project"

#  Scenario: Successfully changing start-and-end weeks to an activity
#    Given an activity "Activity" exists
#    When the employee changes the start week to 1 and end week to 2 for the activity
#    Then the start and end weeks of the activity are updated to 1 and 2
#    And the start and end weeks of the project containing the activity are updated to 1 and 2
#
#  Scenario: Successfully setting budgeted time for an activity
#    Given the budgeted time for the activity "Activity" is set to 100.0 hours
#    Then the budgeted time for the activity is updated to 100.0 hours

#  Scenario: An employee registers time consumed on an activity they are not assigned to
#    Given the employee "huba" is logged in
#    When the employee "huba" attempts to register time consumed on the activity "activity"
#    Then the consumed time on the activity "activity" is updated
#    And the working hours of the employee "huba" is updated