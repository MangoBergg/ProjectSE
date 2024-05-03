package example.whitebox;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import dtu.example.ui.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateActivityWB {
    ProjectManagementApp projectManagementApp = new ProjectManagementApp();
    private Project testProject;
    private Activity testActivity;
    private ErrorMessageHolder errorMessage;

    public CreateActivityWB(ProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage) {
        this.projectManagementApp = projectManagementApp;
        this.errorMessage = errorMessage;
    }

    @When("the employee tries to make an activity with name {string}")
    public void theEmployeeTriesToMakeAnActivityWithName(String string) throws Exception {
        testProject = projectManagementApp.createProject("test");
        try {
            testActivity = projectManagementApp.createActivity(string, testProject);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @When("that activity {string} already exists in the project")
    public void thatActivityAlreadyExistsInTheProject(String string) {
        try {
            testActivity = projectManagementApp.createActivity(string, testProject);
        } catch (Exception e) {
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