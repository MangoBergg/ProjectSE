Feature: Create a new project
	Description: Allows an employee to set a project manager in a project
	Actor: Employee

	Scenario: Successfully assigning a project manager
        Given the project named "Project" already exists in the list of projects
		When the user registers a project manager
		Then the project manager is updated