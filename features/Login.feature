Feature: Log in as employee
  Description: When the employee logs into the system for the first time, the employee's ID is saved in the system. If the employee's ID is already in the system, the employee logs in.
  Actor: Employee

  Scenario: Successfully creating an employee in the system
    Given the employee "huba" logs into the system for the first time
    When the employee "huba" is created
    Then the list of employees contains "huba"

  Scenario: Successfully logging in
    Given the list of employees contains "huba"
    Then the employee logs into the system