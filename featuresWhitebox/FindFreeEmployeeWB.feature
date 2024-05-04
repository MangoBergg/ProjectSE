Feature: Employee searched for available employee for activity
    Description: Whitebox for employee searching for available employee for an activity
    Actor: Employee

    Scenario: 1(true), 2
        When the employee searches for available employees for an activity "activity" in an empty employeeList
        Then an error message "There are no employees in the system" is given

    Scenario: 1(false), 3(true), 4
        When the employee searches for available employees for an activity "activity" in an employeeList that is not empty
        And the activity doesnt have defined weeks
        Then an error message "Activity must have defined start and end weeks" is given

    Scenario: 1(false), 3(false), 5(true)
        When the employee searches for available employees for an activity "activity" with start and end weeks in an employeeList that is not empty
        And no available employee is found for the activity
        Then an error message "No employee was found for that activity" is given

    Scenario: 1(false), 3(false), 5(false), 6, 7
        When the employee searches for available employees for an activity "activity"
        Then a list containing the employee "huba" is returned