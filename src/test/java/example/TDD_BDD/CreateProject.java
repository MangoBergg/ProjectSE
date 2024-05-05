package example.TDD_BDD;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import system.program.interfaces.IProjectManagementApp;
import system.program.model.ErrorMessageHolder;
import system.program.model.ProjectManagementApp;

public class CreateProject {

    IProjectManagementApp projectManagementApp = new ProjectManagementApp();
    private String projectName;
    private ErrorMessageHolder errorMessage;

    public CreateProject(IProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage) {
        this.projectManagementApp = projectManagementApp;
        projectManagementApp.getProjectRepository().reset();
        projectManagementApp.getActivityRepository().reset();
        projectManagementApp.getEmployeeRepository().reset();
        this.errorMessage = errorMessage;
    }

    // The following code is reused from Hubert's video
    @When("a new project named {string} is created")
    public void aNewProjectNamedIsCreated(String string) {
        projectName = string;
        try {
            projectManagementApp.getProjectFactory().createProject(string);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    
    // The following code is reused from Hubert's video
    @Then("the project is added to the list of projects")
    public void theProjectIsAddedToTheListOfProjects() {
        assertTrue(projectManagementApp.getProjectRepository().containsProject(projectName));
    }

    // The following code is reused from Hubert's video
    @Given("the project named {string} already exists in the list of projects")
    public void theProjectNamedAlreadyExistsInTheListOfProjects(String string) throws Exception {
        projectManagementApp.getProjectFactory().createProject(string);
    }

    @When("the employee attempts to create a new project without specifying a name")
    public void theEmployeeAttemptsToCreateANewProjectWithoutSpecifyingAName() throws Exception {
        try {
            projectManagementApp.getProjectFactory().createProject("");
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