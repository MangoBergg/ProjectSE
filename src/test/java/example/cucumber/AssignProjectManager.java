package example.cucumber;

import static org.junit.jupiter.api.Assertions.assertTrue;

import dtu.example.ui.Employee;
import dtu.example.ui.Project;
import dtu.example.ui.ProjectManagementApp;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AssignProjectManager {

    ProjectManagementApp projectManagementApp = new ProjectManagementApp();
    private Project project;

    public AssignProjectManager(ProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage) {
        this.projectManagementApp = projectManagementApp;
    }

    @When("the user registers a project manager")
    public void theUserRegistersAProjectManager() throws Exception {
        project = projectManagementApp.getProjectFromName("Project");
        project.setProjectManager(new Employee("juba"));
    }

    @Then("the project manager is updated")
    public void theProjectManagerIsUpdated() {
        assertTrue(project.getProjectManager().getEmployeeID().equals("juba"));
    }
}