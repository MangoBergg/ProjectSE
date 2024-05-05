package example.TDD_BDD;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import system.program.interfaces.IActivity;
import system.program.interfaces.IProject;
import system.program.interfaces.IProjectManagementApp;
import system.program.model.ErrorMessageHolder;
import system.program.model.ProjectManagementApp;

import static org.junit.Assert.assertTrue;

public class BudgetedTime {

    IProjectManagementApp projectManagementApp = new ProjectManagementApp();
    private ErrorMessageHolder errorMessage;
    private IProject testProject;
    private IActivity testActivity;

    public BudgetedTime(IProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage){
        this.projectManagementApp = projectManagementApp;
        projectManagementApp.getProjectRepository().reset();
        projectManagementApp.getActivityRepository().reset();
        projectManagementApp.getEmployeeRepository().reset();
        this.errorMessage = errorMessage;
    }

    @Given("the budgeted time for the activity {string} is set to {double} hours")
    public void the_budgeted_time_for_the_activity_is_set_to_hours(String string, Double double1) throws Exception {
        testProject = projectManagementApp.getProjectFactory().createProject("project");
        testActivity = projectManagementApp.getActivityFactory().createActivity(string, testProject);
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