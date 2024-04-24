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
	private Project testProject, testProject2, testProject3, testProject4;

	private ErrorMessageHolder errorMessage;

	public CreateProject() throws Exception {
		projectSystemApp = new ProjectSystemApp();
		errorMessage = new ErrorMessageHolder();
	}

	@Given("the employee attempts to create a new project")
	public void the_employee_attempts_to_create_a_new_project() throws Exception {
		testProject = new Project("testProject");
	}

	@When("there is no existing project")
	public void there_is_no_existing_project() {
		assertFalse(projectSystemApp.hasProjectWithName(testProject));
	}

	@Then("the project is added to the system")
	public void the_project_is_added_to_the_system() throws Exception {
		projectSystemApp.addProject(testProject);
	}

	@Given("the employee is logged into the system")
	public void the_employee_is_logged_into_the_system() {
		projectSystemApp.login();
		assertTrue(projectSystemApp.isLoggedIn());
	}

	@When("the employee attempts to create a new project without specifying a name")
	public void the_employee_attempts_to_create_a_new_project_without_specifying_a_name() throws Exception {
		try {
			testProject2 = new Project("");
		} catch (Exception e) {
			errorMessage.setErrorMessage(e.getMessage());
		}
	}

	@When("the employee attempts to create a new project with the name {string}")
	public void theEmployeeAttemptsToCreateANewProjectWithTheName(String string) {
		assertTrue(true);
	}

	@When("a project already exists in the system")
	public void aProjectAlreadyExistsInTheSystem()  {
		try {
			testProject3 = new Project("name");
			testProject4 = new Project("name");

			projectSystemApp.addProject(testProject3);
			projectSystemApp.addProject(testProject4);
		} catch (Exception e) {
			errorMessage.setErrorMessage(e.getMessage());
		}
	}

	@Then("an error message {string} is given")
	public void anErrorMessageStringIsGiven(String errorMessage) {
		assertEquals(errorMessage, this.errorMessage.getErrorMessage());
	}

}
