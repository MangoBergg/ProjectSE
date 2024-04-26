package example.cucumber;

import dtu.example.ui.Activity;
import dtu.example.ui.Project;
import dtu.example.ui.ProjectManagementApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static org.junit.Assert.*;

public class ChangeStartAndEndWeeks {

    ProjectManagementApp projectManagementApp = new ProjectManagementApp();
    private ErrorMessageHolder errorMessage;
    private Project testProject;
    private Activity testActivity;

    public ChangeStartAndEndWeeks(ProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage) {
        this.projectManagementApp = projectManagementApp;
        this.errorMessage = errorMessage;
    }

    @Given("an activity {string} exists without specific start-and-end weeks")
    public void anActivityExistsWithoutSpecificStartAndEndWeeks(String string) throws Exception {
        testProject = projectManagementApp.createProject("project");
        testActivity = projectManagementApp.createActivity(string, testProject);
        assertNotNull(testActivity.getStartEndWeeks());
    }

    @When("the employee assigns start and end week to the activity")
    public void theEmployeeAssignsStartAndEndWeekToTheActivity() {
        testActivity.updateStartEndWeeks(1, 2);
    }

    @Then("the start and end weeks of the activity are updated")
    public void theStartAndEndWeeksOfTheActivityAreUpdated() {
        int[] startEndWeeks = testActivity.getStartEndWeeks();
        assertTrue(startEndWeeks[0] == 1 && startEndWeeks[1] == 2);
    }

    @Then("the start and end weeks of the project containing the activity are updated")
    public void theStartAndEndWeeksOfTheProjectContainingTheActivityAreUpdated() {
        int[] startEndWeeks = testActivity.parentProject.getStartEndWeeks();
        assertTrue(startEndWeeks[0] == 1 && startEndWeeks[1] == 2);
    }
}
