Feature: Create an activity in a project
  Description: Enables an employee to add a new activity to an existing project, ensuring activity names are unique within the project.
  Actor: Employee


  Scenario: Fail to create a new activity with a name that already exists
    Given the employee selects a project named "Project" from the list of projects
    And the activity named "Activity" already exists in the list of activities for a project
    When a new activity named "Activity" is created
    Then an error message "The activity already exists in this project" is given

  Scenario: Fail to create a new activity with a no name
    Given the employee selects a project named "Project" from the list of projects
    When the employee tries to make an activity with an empty name ""
    Then an error message "Give name for the activity" is given

  Scenario: Creating a new activity in a project
    Given the employee selects a project named "Project" from the list of projects
    When a new activity named "Activity" is created
    Then the activity is added to the list of activity