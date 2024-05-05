package example.TDD_BDD;

import static org.junit.jupiter.api.Assertions.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import system.program.interfaces.IProject;
import system.program.interfaces.IProjectManagementApp;
import system.program.model.Developer;
import system.program.model.ErrorMessageHolder;
import system.program.model.ProjectManagementApp;

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