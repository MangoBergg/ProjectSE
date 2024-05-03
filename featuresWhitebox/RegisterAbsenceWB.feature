Feature: Employee registers absence
    Description: Whitebox for employee registering absence
    Actor: Employee

    Scenario: 1(true), 3
        When the employee tries to register absence with the reason "" and weekStart is 2 and weekEnd is 1
        Then an error message "Starting week must be before the end week" is given

    Scenario: 1(false), 2(true), 4
        When the employee tries to register absence with the reason "" and weekStart is 1 and weekEnd is 2
        Then an error message "You must give a reason for your absence" is given

    Scenario: 1(false), 2(false), 5
        When the employee tries to register absence with the reason "reason" and weekStart is 1 and weekEnd is 2
        Then the employee has registered absence