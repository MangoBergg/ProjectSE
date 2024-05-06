Feature: Create an activity in a project
  Description: Enables an employee to add a new activity to an existing project, ensuring activity names are unique within the project.
  Actor: Employee

  Scenario: Creating a new activity in a project
    Given the employee selects a project named "Project" from the list of projects
    When a new activity named "Activity" is created
    Then the activity is added to the list of activity

  Scenario: Fail to create an activity with the same name as another activity in the same project
    Given the employee selects a project named "Project" from the list of projects
    When the employee attemps to create an activity "Activity" when the activity already exists
    Then an assertion error message "The activity already exists in this project" is thrown

  Scenario: Fail to create an activity without specifying a name
    Given the employee selects a project named "Project" from the list of projects
    When the employee attemps to create an activity "" without a name
    Then an assertion error message "Name cannot be empty" is thrown