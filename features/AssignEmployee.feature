Feature: Assigning an employee to an activity
  Description: Allows an employee to assign an employee to an activity, ensuring that assignments are only made when appropriate based on current assignments and availability.
  Actor: Employee

  Scenario: Successfully assigning an employee to an activity
    Given the employee attempts to assign an employee "huba" to the activity "Activity" in the project "Project"
    Then the employee is assigned to the activity

  Scenario: Fail to assign an employee who is already assigned to the activity
    Given the employee attempts to assign an employee "huba" to the activity "Activity" in the project "Project"
    When the employee "huba" is already assigned to the activity
    Then an error message "The employee is already assigned to the activity" is given