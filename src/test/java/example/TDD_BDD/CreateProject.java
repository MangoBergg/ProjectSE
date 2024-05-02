package example.TDD_BDD;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import dtu.example.ui.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateProject {

    ProjectManagementApp projectManagementApp = new ProjectManagementApp();
    private String projectName;
    private ErrorMessageHolder errorMessage;

    public CreateProject(ProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage) {
        this.projectManagementApp = projectManagementApp;
        this.errorMessage = errorMessage;
    }

    // The following code is reused from Hubert's video
    @When("a new project named {string} is created")
    public void aNewProjectNamedIsCreated(String string) {
        projectName = string;
        try {
            projectManagementApp.createProject(string);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    
    // The following code is reused from Hubert's video
    @Then("the project is added to the list of projects")
    public void theProjectIsAddedToTheListOfProjects() {
        assertTrue(projectManagementApp.containsProject(projectName));
    }

    // The following code is reused from Hubert's video
    @Given("the project named {string} already exists in the list of projects")
    public void theProjectNamedAlreadyExistsInTheListOfProjects(String string) throws Exception {
        projectManagementApp.createProject(string);
    }

    @When("the employee attempts to create a new project without specifying a name")
    public void theEmployeeAttemptsToCreateANewProjectWithoutSpecifyingAName() throws Exception {
        try {
            projectManagementApp.createProject("");
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    // The following code is reused from Hubert's video
    @Then("an error message {string} is given")
    public void anErrorMessageIsGiven(String string) {
        assertEquals(string, errorMessage.getErrorMessage());
    }
}