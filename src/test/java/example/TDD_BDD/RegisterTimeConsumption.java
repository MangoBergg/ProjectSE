package example.TDD_BDD;

import dtu.example.interfaces.IActivity;
import dtu.example.interfaces.IProject;
import dtu.example.ui.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class RegisterTimeConsumption {

    private IProject testProject;
    private IActivity testActivity;

    private Employee employee;

    private double before, after;
    private ErrorMessageHolder errorMessage;
    private ProjectManagementApp projectManagementApp;


    public RegisterTimeConsumption(ProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage) {
        this.projectManagementApp = projectManagementApp;
        this.errorMessage = errorMessage;
    }


    @Given("the employee {string} is assigned to the activity {string} in the project {string}")
    public void theEmployeeIsAssignedToTheActivityInTheProject(String string, String string2, String string3) throws Exception {
        employee = new Developer(string);
        testProject = projectManagementApp.createProject(string3);
        testActivity = projectManagementApp.createActivity(string2, testProject);
        testActivity.assignEmployee(employee);
        assertTrue(testActivity.containsAssignedEmployee(employee));
    }

    @Given("the employee {string} is not assigned to the activity {string}")
    public void the_employee_is_not_assigned_to_the_activity(String string, String string2) throws Exception {
        employee = new Developer(string);
        testProject = projectManagementApp.createProject("Project");
        testActivity = projectManagementApp.createActivity(string2, testProject);
        assertFalse(testActivity.containsAssignedEmployee(employee));
    }

    @When("the employee registers consumed time as {double} hours on the activity {string}")
    public void theEmployeeRegistersConsumedTimeAsHoursOnTheActivity(Double double1, String string) {
        try {
            before = testActivity.getConsumedTime();
            employee.updateConsumedTime(double1, testActivity);
            after = testActivity.getConsumedTime();
        } catch (AssertionError e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @Then("the consumed time on the activity is updated")
    public void theConsumedTimeOnTheActivityIsUpdated() {
        assertTrue(before != after);
    }
}