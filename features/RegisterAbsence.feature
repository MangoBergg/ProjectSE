 Feature:     Register absence as an employee
    Description: An employee assigns itself as absent at a specific start and end date
    Actor:       Employee
 
    Scenario: An employee registers absence
        When the employee "huba" attempts to register absence with the reason "reason", and a start week 2 that is before the end week 5
        Then the employee is registered as absent from the start week 2 till the end week 5 because of "reason"
    
    Scenario: An employee registers absence with invalid dates
        When the employee "huba" attempts to register absence with the reason "reason", and a starting week 5 that is after the end week 2
        Then an error message "Starting week must be before the end week" is given

    Scenario: An employee registers absence with invalid reason
        When the employee "huba" attempts to register absence with the reason "", and a starting week 2 that is before the end date 5
        Then an error message "You must give a reason for your absence" is given