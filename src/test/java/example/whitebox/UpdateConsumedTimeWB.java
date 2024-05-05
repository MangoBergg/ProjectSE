package example.whitebox;

import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import system.program.interfaces.IActivity;
import system.program.interfaces.IEmployee;
import system.program.interfaces.IProject;
import system.program.interfaces.IProjectManagementApp;
import system.program.model.Activity;
import system.program.model.Developer;
import system.program.model.ErrorMessageHolder;
import system.program.model.ProjectManagementApp;

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
