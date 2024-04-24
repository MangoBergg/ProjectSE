Feature: Create an activity in a project
  Description: Enables an employee to add a new activity to an existing project, ensuring activity names are unique within the project.
  Actor: Employee

  Scenario: Creating a new activity in a project
    Given the employee is logged into the system
    When the employee selects a project named "Project"
    And the employee attempts to create a new activity named "Activity"
    And no activity named "Activity" exists in the project
    Then the activity added to the project

  Scenario: Attempting to create a new activity with a duplicate name in a project
    Given the employee attempts to create a new activity named "Activity"
    When the activity named "Activity" already exists in the project
    #Then the activity is not created
    Then an error message "An activity named ’Activity’ already exists in this project" is given