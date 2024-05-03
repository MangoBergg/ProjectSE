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
    private Employee testEmployee;
    private ErrorMessageHolder errorMessage;

    public CreateActivityWB(ProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage) {
        this.projectManagementApp = projectManagementApp;
        this.errorMessage = errorMessage;
    }

    @When("the employee tries to make an activity with name {string}")
    public void theEmployeeTriesToMakeAnActivityWithName(String string) {
        testEmployee = new Developer("huba");
        try {
            projectManagementApp.createActivity(string, testProject);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }
}