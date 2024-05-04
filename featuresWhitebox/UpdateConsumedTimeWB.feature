Feature: Employee updates consumed time on an activity
    Description: Whitebox for employee updating consumed time on an activity
    Actor: Employee

    Scenario: 1(true), 2
        When the employee updates consumed time and the input double is 0.3 hours

    Scenario: 1(false), 3(true), 4
        When the employee updates consumed time and the input double is 0.7 hours

    Scenario: 1(false),3(false),5,6,7,8,9,10,11
        When the employee updates consumed time and the input double is 2.0 hours
        Then The user’s consumed time for the activity programming is updated by adding double1 hours to the activity programming