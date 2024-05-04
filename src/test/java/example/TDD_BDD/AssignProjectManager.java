package example.TDD_BDD;

import static org.junit.jupiter.api.Assertions.assertTrue;

import dtu.example.interfaces.IProject;
import dtu.example.ui.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AssignProjectManager {

    ProjectManagementApp projectManagementApp = new ProjectManagementApp();
    private IProject testProject;

    public AssignProjectManager(ProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage) {
        this.projectManagementApp = projectManagementApp;
    }

    @Given("a project {string} exists")
    public void an_activity_exists(String string) throws Exception {
        testProject = projectManagementApp.createProject("project");
    }

    @When("the user registers a project manager")
    public void theUserRegistersAProjectManager() throws Exception {
        testProject = projectManagementApp.getProjectFromName("Project");
        testProject.setProjectManager(new Developer("juba"));
    }

    @Then("the project manager is updated")
    public void theProjectManagerIsUpdated() {
        assertTrue(testProject.getProjectManager().getEmployeeID().equals("juba"));
    }
}