package example.whitebox;

import static org.junit.Assert.assertTrue;

import java.util.List;

import dtu.example.interfaces.IActivity;
import dtu.example.interfaces.IEmployee;
import dtu.example.interfaces.IProject;
import dtu.example.ui.Activity;
import dtu.example.ui.Developer;
import dtu.example.ui.Employee;
import dtu.example.ui.ErrorMessageHolder;
import dtu.example.ui.Project;
import dtu.example.ui.ProjectManagementApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UpdateConsumedTimeWB {
    ProjectManagementApp projectManagementApp = new ProjectManagementApp();
    private IProject testProject;
    private IActivity testActivity;
    private IEmployee testEmployee;
    private ErrorMessageHolder errorMessage;

    public UpdateConsumedTimeWB(ProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage) {
        this.projectManagementApp = projectManagementApp;
        this.errorMessage = errorMessage;
    }

    @When("the employee updates consumed time and the input double is {double} hours")
    public void theEmployeeUpdatesConsumedTimeAndTheInputDoubleIsHours(Double double1) throws Exception {
        testProject = projectManagementApp.createProject("project");
        testActivity = new Activity("activity", testProject);
        testEmployee = new Developer("huba");
        try {
            testEmployee.updateConsumedTime(double1, testActivity);
        } catch (AssertionError e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }
    
    @Then("the user’s consumed time for the activity programming is updated by adding double1 hours to the activity programming")
    public void theUserSConsumedTimeForTheActivityProgrammingIsUpdatedByAddingDouble1HoursToTheActivityProgramming() {
        assertTrue(testActivity.getConsumedTime() == 2.0);
        assertTrue(testEmployee.getConsumedTimes().get(0).time == 2.0);
        assertTrue(true);
    }
}
