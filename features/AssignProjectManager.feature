Feature: Assigning a project manager
  Description: An employee can assign a project manager to a project
  Actor: Employee

  Scenario: Successfully assigning oneself as the project manager when there is no project manager for the project "Project"
    Given there is no project manager for the project "Project"
    When an employee attempts to assign an employee with name "huba" as project manager for the project
    Then the employee "huba" is the project manager for the project "Project"

  Scenario: Attempting to assign oneself as project manager when another project manager already exists.
    Given there is a project manager "abcd" for the project "Project"
    When an employee attempts to assign an employee with name "huba" as project manager for the project
    Then an error message "The employee 'abcd' is project manager for the project 'Project'" is given