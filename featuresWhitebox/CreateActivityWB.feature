Feature: Employee makes a new activity in a project
    Description: Whitebox for employee making a new activity
    Actor: Employee

    Scenario: 1(true), 2
        When the employee tries to make an activity with name "already exists"
        And that activity "already exists" already exists in the project
        Then an error message "The activity already exists in this project" is given

    Scenario: 1(false), 3(true), 4
        When the employee tries to make an activity with name ""
        Then an error message "Give name for the activity" is given

    Scenario: 1(false), 2(false), 5
        When the employee tries to make an activity with name "not exists"
        And that activity does not already exist in the project
        Then the new activity is created in that project