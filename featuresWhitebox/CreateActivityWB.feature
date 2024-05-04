Feature: Employee makes a new activity in a project
    Description: Whitebox for employee making a new activity
    Actor: Employee

    Scenario: 1(false), 2(false), 5
        When the employee tries to make an activity with name "not exists"
        And that activity does not already exist in the project
        Then the new activity is created in that project