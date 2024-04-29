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


    }
}