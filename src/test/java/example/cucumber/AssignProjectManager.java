package example.cucumber;

import dtu.example.ui.Employee;
import dtu.example.ui.Project;
import dtu.example.ui.ProjectManagementApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Before;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AssignProjectManager {

    private ProjectManagementApp projectManagementApp;
    private String projectName;
    private String activityName;
    private ErrorMessageHolder errorMessage;
    private Project testProject;
    private Employee employee;

    public AssignProjectManager(ProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage) {
        this.projectManagementApp = projectManagementApp;
        this.errorMessage = errorMessage;
    }

    @Given("there is no project manager for the project {string}")
    public void thereIsNoProjectManagerForTheProject(String string) {

        try {
            employee = projectManagementApp.createEmployee("huba");
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }

        try {
            testProject = projectManagementApp.createProject(string);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }

        assertTrue(testProject.getProjectLeader() == null);
        throw new io.cucumber.java.PendingException();
    }

    @Given("an employee attempts to assign an employee with name {string} as project manager for the project {string}")
    public void an_employee_attempts_to_assign_an_employee_with_name_as_project_manager_for_the_project(String string1, String string2) {
        testProject.setProjectLeader(employee);
        throw new io.cucumber.java.PendingException();
    }

    @Then("the employee {string} is the project manager for the project {string}")
    public void the_employee_is_the_project_manager_for_the_project(String string, String string2) {
        assertTrue(testProject.getProjectLeader().equals(employee));
        throw new io.cucumber.java.PendingException();
    }

}