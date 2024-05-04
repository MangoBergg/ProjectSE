package example.TDD_BDD;

import static org.junit.jupiter.api.Assertions.assertTrue;

import dtu.example.interfaces.IProject;
import dtu.example.interfaces.IProjectManagementApp;
import dtu.example.model.Developer;
import dtu.example.model.ErrorMessageHolder;
import dtu.example.model.ProjectManagementApp;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AssignProjectManager {

    IProjectManagementApp projectManagementApp = new ProjectManagementApp();
    private IProject testProject;

    public AssignProjectManager(IProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage) {
        this.projectManagementApp = projectManagementApp;
        projectManagementApp.getProjectRepository().reset();
        projectManagementApp.getActivityRepository().reset();
        projectManagementApp.getEmployeeRepository().reset();
    }

    @Given("a project {string} exists")
    public void an_activity_exists(String string) throws Exception {
        testProject = projectManagementApp.getProjectFactory().createProject("project");
    }

    @When("the user registers a project manager")
    public void theUserRegistersAProjectManager() throws Exception {
        testProject = projectManagementApp.getProjectRepository().getProjectFromName("Project");
        testProject.setProjectManager(new Developer("juba"));
    }

    @Then("the project manager is updated")
    public void theProjectManagerIsUpdated() {
        assertTrue(testProject.getProjectManager().getEmployeeID().equals("juba"));
    }
}