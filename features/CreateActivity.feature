Feature: Create an activity in a project
  Description: Enables an employee to add a new activity to an existing project, ensuring activity names are unique within the project.
  Actor: Employee


  Scenario: Creating a new activity in a project
    Given the employee selects a project named "Project" from the list of projects
    When a new activity named "Activity" is created
    Then the activity is added to the list of activity