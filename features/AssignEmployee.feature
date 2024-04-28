Feature: Assigning an employee to an activity
  Description: Allows an employee to assign an employee to an activity, ensuring that assignments are only made when appropriate based on current assignments and availability.
  Actor: Employee

  Scenario: Successfully assigning an employee to an activity
    Given the employee attempts to assign an employee "employee ID" to the activity
    When the employee "employee ID" is not already assigned to the activity
    Then the employee "employee ID" is assigned to the activity "Activity"

  #Scenario: Fail to assign an employee who is already assigned to the activity
  #  Given the employee attempts to assign an employee "employee ID" from the list "Employees" to of employees the activity "Activity"
  #  And the employee "employee ID" is already assigned to the activity "activity"
  #  Then an error message "The employee is already assigned to the activity ’Activity’" is given