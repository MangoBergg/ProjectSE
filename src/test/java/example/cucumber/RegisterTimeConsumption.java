package example.cucumber;

import dtu.example.ui.Activity;
import dtu.example.ui.Project;
import dtu.example.ui.ProjectManagementApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class RegisterTimeConsumption {

    private Activity testActivity;
    private Project testProject;
    private String employeeID;
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
        employeeID = string;
        activityName = string2;
        projectName = string3;
        testProject = projectManagementApp.createProject(projectName);
        testActivity = projectManagementApp.createActivity(activityName, testProject);
        testActivity.assignEmployee(employeeID);
    }

    @When("the employee registers consumed time as {double} hours on the activity")
    public void theEmployeeRegistersConsumedTimeAsHoursOnTheActivity(Double double1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the consumed time on the activity is updated by adding {double} hours")
    public void theConsumedTimeOnTheActivityIsUpdatedByAddingHours(Double double1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
