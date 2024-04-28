Feature: Log in as employee
  Description: When the employee logs into the system for the first time. The employee's ID is saved in the system.
  Actor: Employee

  Scenario: Successfully logging into the system
    Given an employee is logged into the system
    When the employee's "employee ID" is created
    Then the employee's "employee ID" is added to the list of employees