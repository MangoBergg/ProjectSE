Feature: Register time consumption
  Description: An employee registers time consumed on an activity
  Actor: Employee

  Scenario: Successfully registering time consumed on an activity which an employee is assigned to
    Given the employee "huba" is assigned to the activity "Activity" in the project "Project"
    When the employee registers consumed time as 5.0 hours on the activity "Activity"
    Then the consumed time on the activity is updated

  Scenario: Fail to register the time consumed on an activity in increments of 0.5 hours
    Given the employee "huba" is assigned to the activity "Activity" in the project "Project"
    When the employee registers consumed time as 4.7 hours on the activity "Activity"

  Scenario: Fail to register the time consumed on an activity as at least 0.5 hours
    Given the employee "huba" is assigned to the activity "Activity" in the project "Project"
    When the employee registers consumed time as 0.0 hours on the activity "Activity"

  Scenario: Successfully registering time consumed on an activity which an employee is not assigned to
    Given the employee "huba" is not assigned to the activity "Activity"
    When the employee registers consumed time as 10.0 hours on the activity "Activity"
    Then the consumed time on the activity is updated