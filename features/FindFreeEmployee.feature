 Feature:     Find free employee
    Description: Retrieves a list of employees free to be assigned to an activity
    Actor:  Employee

    Scenario: Finding free employees for activity assignment
         Given "huba" needs to assign employees to the activity "Activity" scheduled for weeks 12 to 14
         When "huba" prompts a list of free employees for the activity "Activity"
         Then a list is returned containing employees who are not absent in week 12 to 14. Not assigned to "activity"