package example.cucumber;

import dtu.example.ui.Activity;
import dtu.example.ui.Project;
import dtu.example.ui.ProjectManagementApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;

public class BudgetedTime {

    ProjectManagementApp projectManagementApp = new ProjectManagementApp();
    private ErrorMessageHolder errorMessage;
    private Project testProject;
    private Activity testActivity;

    public BudgetedTime(ProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage){
        this.projectManagementApp = projectManagementApp;
        this.errorMessage = errorMessage;
    }

    @Given("the budgeted time for the activity {string} is set to {double} hours")
    public void the_budgeted_time_for_the_activity_is_set_to_hours(String string, Double double1) throws Exception {
        testProject = projectManagementApp.createProject("project");
        testActivity = projectManagementApp.createActivity(string, testProject);
        try {
            testActivity.updateBudgetedTime(double1);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }


    @Then("the budgeted time for the activity is updated to {double} hours")
    public void the_budgeted_time_for_the_activity_is_updated_to_hours(Double double1) {
        assertTrue(testActivity.getBudgetedTime() == double1);
    }
}