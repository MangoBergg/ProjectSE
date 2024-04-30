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
    private Project testProject;
    private Employee employee;
    private String projectName;
    private String activityName;
    private ErrorMessageHolder errorMessage;
    private ProjectManagementApp projectManagementApp;


    public AssignEmployee(ProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage) {
        this.projectManagementApp = projectManagementApp;
        this.errorMessage = errorMessage;
    }

    @Given("the employee attempts to assign an employee {string} to the activity {string} in the project {string}")
    public void the_employee_attempts_to_assign_an_employee_to_the_activity_in_the_project(String string, String string2, String string3) throws Exception {
        employee = new Employee(string);
        activityName = string2;
        projectName = string3;
        testProject = projectManagementApp.createProject(projectName);
        testActivity = projectManagementApp.createActivity(activityName, testProject);
        try {
            testActivity.assignEmployee(employee);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }



    @Then("the employee is assigned to the activity")
    public void the_employee_is_assigned_to_the_activity() {
        assertTrue(testActivity.containsAssignedEmployee(employee.getEmployeeID()));
    }


    @When("the employee {string} is already assigned to the activity")
    public void the_employee_is_already_assigned_to_the_activity(String string) {
        try {
            testActivity.assignEmployee(employee);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

}