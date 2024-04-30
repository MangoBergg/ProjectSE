Feature: Get status report
  Description: An employee follows up on the time consumption and on a project.
  Actor: Employee

  Scenario: An employee follows up on the time consumption on a project.
    Given the employee selects a project named "Project" from the list of projects
    When the employee prompts a status report for the project "Project"
    Then a status report for the project is created
    And the status report for the project contains the budgeted time for each activity
    And the status report for the project contains the time consumption for each activity