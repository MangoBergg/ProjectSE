Feature: Log in as employee
  Description: When the employee logs into the system for the first time, the employee's ID is saved in the system. If the employee's ID is already in the system, the employee logs in.
  Actor: Employee

  Scenario: Successfully creating an employee in the system
    Given the employee "employee ID" logs into the system for the first time
    When the employee "employee ID" is created
    Then the list of employees contains "employee ID"

  Scenario: Successfully logging in
    Given the list of employees contains "employee ID"
    Then the employee logs into the system