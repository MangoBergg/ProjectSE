package example.cucumber;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import dtu.example.ui.ProjectSystemApp;
import dtu.example.ui.Project;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CreateProject {
	private ProjectSystemApp projectSystemApp;
	private Project testProject;
	private ErrorMessageHolder errorMessage;

	public CreateProject() {
		projectSystemApp = new ProjectSystemApp();
		errorMessage = new ErrorMessageHolder();
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

	@Given("the employee is logged into the system")
	public void the_employee_is_logged_into_the_system() {
		projectSystemApp.login();
		assertTrue(projectSystemApp.isLoggedIn());
	}

	@When("the employee attempts to create a new project without specifying a name")
	public void the_employee_attempts_to_create_a_new_project_without_specifying_a_name() throws Exception {
		try {
			testProject = new Project("");
		} catch (Exception e) {
			errorMessage.setErrorMessage(e.getMessage());
		}

	}

	@Then("an error message is given")
	public void an_error_message_is_given() {
		assertEquals(errorMessage.getErrorMessage(), "Give name");
	}
}
