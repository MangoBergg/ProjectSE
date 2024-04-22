Feature: Create a new project
	Description: Allows an employee to create a new project within the system, ensuring project names are unique and specified.
	Actor: Employee

	Scenario: Creating a project as an employee:
		Given the employee attempts to create a new project
		When there is no existing project
		Then the project is successfully added to the system

	#Scenario: Attempting to create a project without specifying a name
	#	Given the employee is logged into the system
	#	When the employee attempts to create a new project without specifying a name
	#	Then an error message is given

	#Scenario: Trying to create a project with a name that already exists:
	#	Given the employee is logged into the system
	#	When the employee attempts to create a new project with the name "Project"
	#	And a project already exists in the system
	#	Then an error message is given