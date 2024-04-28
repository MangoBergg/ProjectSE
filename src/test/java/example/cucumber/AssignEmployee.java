package example.cucumber;

import dtu.example.ui.Activity;
import dtu.example.ui.Employee;
import dtu.example.ui.Project;
import dtu.example.ui.ProjectManagementApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AssignEmployee {

    private Activity testActivity;
    private String testEmployee;
    private String employeeList;
    private String activityName;
    private ErrorMessageHolder errorMessage;
    private ProjectManagementApp projectManagementApp;
    private Project testProject;

    public AssignEmployee(Project testProject, Employee testEmployee, Activity testActivity, ProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage) {
        this.testProject = testProject;
        this.testActivity = testActivity;
        this.errorMessage = errorMessage;
        this.testEmployee = testEmployee;
        this.projectManagementApp = projectManagementApp;
    }

    @Given("the employee attempts to assign an employee {string} from the list {string} of employees to the activity {string}")
    public void theEmployeeAttemptsToAssignAnEmployeeFromTheListOfEmployeesToTheActivity(String string, String string2, String string3) {
        testEmployee = string;
        employeeList = string2;
        activityName = string3;
        testActivity = projectManagementApp.createActivity(activityName, testProject);

        try {
            projectManagementApp.createActivity(string);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    projectName = string;
    testProject = projectManagementApp.createProject(projectName);
        projectManagementApp.createActivity(string, testProject);

        try {
        projectManagementApp.createActivity(string, testProject);
    } catch (Exception e) {
        errorMessage.setErrorMessage(e.getMessage());
    }





    @When("the employee {string} is not already assigned to the activity {string}")
    public void theEmployeeIsNotAlreadyAssignedToTheActivity(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the employee {string} is assigned to the activity {string}")
    public void theEmployeeIsAssignedToTheActivity(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
