Feature: Employee searched for available employee for activity
    Description: Whitebox for employee searching for available employee for an activity
    Actor: Employee

    Scenario: 1(true), 2
        When the employee searches for available employees for an activity "activity" in an empty employeeList

    Scenario: 1(false), 3(true), 4
        When the employee searches for available employees for an activity "activity" in an employeeList that is not empty
        And the activity doesnt have defined weeks

    Scenario: 1(false), 3(false), 5(true)
        When the employee searches for available employees for an activity "activity" with start and end weeks in an employeeList that is not empty
        And no available employee is found for the activity

    Scenario: 1(false), 3(false), 5(false), 6, 7
        When the employee searches for available employees for an activity "activity"
        Then a list containing the employee "huba" is returned