package example.whitebox;

import static org.junit.Assert.assertTrue;

import dtu.example.interfaces.IActivity;
import dtu.example.interfaces.IEmployee;
import dtu.example.interfaces.IProject;
import dtu.example.interfaces.IProjectManagementApp;
import dtu.example.model.Activity;
import dtu.example.model.Developer;
import dtu.example.model.ErrorMessageHolder;
import dtu.example.model.ProjectManagementApp;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UpdateConsumedTimeWB {
    IProjectManagementApp projectManagementApp = new ProjectManagementApp();
    private IProject testProject;
    private IActivity testActivity;
    private IEmployee testEmployee;
    private ErrorMessageHolder errorMessage;

    public UpdateConsumedTimeWB(IProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage) {
        this.projectManagementApp = projectManagementApp;
        projectManagementApp.getProjectRepository().reset();
        projectManagementApp.getActivityRepository().reset();
        projectManagementApp.getEmployeeRepository().reset();
        this.errorMessage = errorMessage;
    }

    @When("the employee updates consumed time and the input double is {double} hours")
    public void theEmployeeUpdatesConsumedTimeAndTheInputDoubleIsHours(Double double1) throws Exception {
        testProject = projectManagementApp.getProjectFactory().createProject("project");
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
