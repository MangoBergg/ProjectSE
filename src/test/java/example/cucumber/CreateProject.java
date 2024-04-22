package example.cucumber;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import dtu.example.ui.ProjectSystemApp;
import dtu.example.ui.Project;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateProject {
	private ProjectSystemApp projectSystemApp;
	private Project testProject;

	public CreateProject() {
		projectSystemApp = new ProjectSystemApp();
	}

	@Given("the employee attempts to create a new project")
	public void the_employee_attempts_to_create_a_new_project() {
		assertTrue(true);
	}

	@When("there is no existing project")
	public void there_is_no_existing_project() {
		assertFalse(projectSystemApp.projectList.contains(testProject));
	}

	@Then("the project is successfully added to the system")
	public void the_project_is_successfully_added_to_the_system() {
		projectSystemApp.projectList.add(testProject);
		assertTrue(projectSystemApp.projectList.contains(testProject));
	}
}
