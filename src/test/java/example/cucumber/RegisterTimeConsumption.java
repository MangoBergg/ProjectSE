package example.cucumber;

import dtu.example.ui.Activity;
import dtu.example.ui.Employee;
import dtu.example.ui.Project;
import dtu.example.ui.ProjectManagementApp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class RegisterTimeConsumption {

    private Activity testActivity;
    private Project testProject;
    private Employee employee;
    private String projectName;
    private String activityName;
    private ErrorMessageHolder errorMessage;
    private ProjectManagementApp projectManagementApp;


    public RegisterTimeConsumption(ProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage) {
        this.projectManagementApp = projectManagementApp;
        this.errorMessage = errorMessage;
    }


    @Given("the employee {string} is assigned to the activity {string} in the project {string}")
    public void theEmployeeIsAssignedToTheActivityInTheProject(String string, String string2, String string3) throws Exception {

    }


    @When("the employee registers consumed time as {double} hours on the activity {string}")
    public void theEmployeeRegistersConsumedTimeAsHoursOnTheActivity(Double double1, String string) throws Exception {

    }

    @Then("the consumed time on the activity is updated")
    public void theConsumedTimeOnTheActivityIsUpdated() {
        
    }



    @Given("the employee {string} is not assigned to the activity {string}")
    public void the_employee_is_not_assigned_to_the_activity(String string, String string2) throws Exception {

    }
}