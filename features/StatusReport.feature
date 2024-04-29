Feature: Get status report
  Description: An employee follows up on the time consumption and on a project.
  Actor: Employee

  Scenario: An employee follows up on the time consumption on a project.
    Given the employee "huba" prompts a status report for the project "Project"
    When the status report for the project is returned
    Then the status report contains the budgeted for each activity
    And the status report contains the time consumed on each activity