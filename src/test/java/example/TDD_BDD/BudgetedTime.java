package example.TDD_BDD;

import dtu.example.interfaces.IActivity;
import dtu.example.interfaces.IProject;
import dtu.example.interfaces.IProjectManagementApp;
import dtu.example.ui.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertTrue;

public class BudgetedTime {

    IProjectManagementApp projectManagementApp = new ProjectManagementApp();
    private ErrorMessageHolder errorMessage;
    private IProject testProject;
    private IActivity testActivity;

    public BudgetedTime(IProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage){
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