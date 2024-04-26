Feature: Create a new project
	Description: Allows an employee to create a new project within the system, ensuring project names are unique and specified.
	Actor: Employee

	Scenario: Creating a project
		When a new project named "Project" is created
		Then the project is added to the list of projects


	Scenario: Fail to create a project with a name that already exists
		Given the project named "Project" already exists in the list of projects
		When a new project named "Project" is created
		Then an error message "Project with that name already exists" is given



	#Scenario: Attempting to create a project without specifying a name
#		Given the employee is logged into the system
#		When the employee attempts to create a new project without specifying a name
#		Then an error message "Give name" is given