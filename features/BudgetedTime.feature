Feature: Manage budgeted time for an activity
  Description: Allows an employee to set the budgeted time for an activity in hours.
  Actor: Employee

  Scenario: Successfully setting budgeted time for an activity
    Given the budgeted time for the activity "Activity" is set to 100.0 hours
    Then the budgeted time for the activity is updated to 100.0 hours

  Scenario: Fail to set the budgeted time in increments of 0.5 hours
    Given the budgeted time for the activity "Activity" is set to 100.7 hours
    Then an error message "Invalid input. Please ensure your number is in increments of 0.5" is given

  Scenario: Fail to set budgeted time for an activity as less than 0.5 hours
    Given the budgeted time for the activity "Activity" is set to 0.0 hours
    Then an error message "Budgeted time must be greater than 0.5 hours" is given
