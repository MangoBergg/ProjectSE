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

    @Given("an activity {string} exists")
    public void an_activity_exists(String string) throws Exception {
        testProject = projectManagementApp.createProject("project");
        testActivity = projectManagementApp.createActivity(string, testProject);
    }

    @When("the employee changes the start week to {int} and end week to {int} for the activity")
    public void theEmployeeChangesTheStartWeekToAndEndWeekToForTheActivity(int int1, int int2) throws Exception {
        testActivity.updateStartEndWeeks(int1, int2);
    }

    @Then("the start and end weeks of the activity are updated to {int} and {int}")
    public void the_start_and_end_weeks_of_the_activity_are_updated_to_and(Integer int1, Integer int2) {
        assertTrue(testActivity.getStartEndWeeks()[0] == int1 && testActivity.getStartEndWeeks()[1] == int2);
    }

    @Then("the start and end weeks of the project containing the activity are updated to {int} and {int}")
    public void the_start_and_end_weeks_of_the_project_containing_the_activity_are_updated_to_and(Integer int1, Integer int2) {
        assertTrue(testActivity.getParentProject().getStartEndWeeks()[0] == int1 && testActivity.getParentProject().getStartEndWeeks()[1] == int2);
    }

    @Given("an activity exists with start week {int} and end week {int}")
    public void an_activity_exists_with_start_week_and_end_week(Integer int1, Integer int2) throws Exception {
        testProject = projectManagementApp.createProject("project");
        testActivity = projectManagementApp.createActivity("test2", testProject);
        testActivity.updateStartEndWeeks(int1, int2);
    }

    @When("the employee attempts to change the start week to {int} and end week to {int}")
    public void the_employee_attempts_to_change_the_start_week_to_and_end_week_to(Integer int1, Integer int2) {
        try {
            testActivity.updateStartEndWeeks(int1, int2);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }

    }
}