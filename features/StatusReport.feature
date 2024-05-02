Feature: Get status report
  Description: An employee follows up on the time consumption and on a project.
  Actor: Employee

  Scenario: An employee follows up on the time consumption on a project.
    When the employee "huba" prompts a status report for the project "Project"
    Then a status report for the project "Project" is returned to the employee "huba" with valuable information.