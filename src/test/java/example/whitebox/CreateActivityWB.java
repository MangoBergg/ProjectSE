package example.whitebox;

import static org.junit.Assert.assertTrue;

import dtu.example.interfaces.IActivity;
import dtu.example.interfaces.IProject;
import dtu.example.interfaces.IProjectManagementApp;
import dtu.example.model.ErrorMessageHolder;
import dtu.example.model.ProjectManagementApp;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateActivityWB {
    IProjectManagementApp projectManagementApp = new ProjectManagementApp();
    private IProject testProject;
    private IActivity testActivity;
    private ErrorMessageHolder errorMessage;

    public CreateActivityWB(IProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage) {
        this.projectManagementApp = projectManagementApp;
        projectManagementApp.getProjectRepository().reset();
        projectManagementApp.getActivityRepository().reset();
        projectManagementApp.getEmployeeRepository().reset();
        this.errorMessage = errorMessage;
    }

    @When("the employee tries to make an activity with name {string}")
    public void theEmployeeTriesToMakeAnActivityWithName(String string) throws Exception {
        testProject = projectManagementApp.getProjectFactory().createProject("test");
        try {
            testActivity = projectManagementApp.getActivityFactory().createActivity(string, testProject);
        } catch (AssertionError e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @When("that activity {string} already exists in the project")
    public void thatActivityAlreadyExistsInTheProject(String string) {
        try {
            testActivity = projectManagementApp.getActivityFactory().createActivity(string, testProject);
        } catch (AssertionError e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @When("that activity does not already exist in the project")
    public void thatActivityDoesNotAlreadyExistInTheProject() {
        assertTrue(testProject.containsActivity(testActivity.getName()));
    }
    @Then("the new activity is created in that project")
    public void theNewActivityIsCreatedInThatProject() {
        assertTrue(testProject.containsActivity(testActivity.getName()));
    }
}