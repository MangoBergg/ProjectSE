package example.whitebox;

import dtu.example.ui.ErrorMessageHolder;
import dtu.example.ui.Project;
import dtu.example.ui.ProjectManagementApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChangeStartAndEndWeeksWB {

    ProjectManagementApp projectManagementApp = new ProjectManagementApp();
    private ErrorMessageHolder errorMessage;
    private Project testProject;

    public ChangeStartAndEndWeeksWB(ProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage) {
        this.projectManagementApp = projectManagementApp;
        this.errorMessage = errorMessage;
    }

    @Given("a project {string} exists")
    public void aProjectExists(String string) {
        try {
            testProject = projectManagementApp.createProject(string);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
        assertTrue(projectManagementApp.containsProject(string));
    }

    @When("the project contains no activities")
    public void theProjectContainsNoActivities() {
        assertFalse(testProject.containsActivity("activity"));
    }

    @Then("the start-and-end weeks of an activity can not be updated")
    public void the_start_and_end_weeks_of_an_activity_can_not_be_updated() {
        assertFalse(testActivity.getStartEndWeeks()[0] == int1 && testActivity.getStartEndWeeks()[1] == int2);
    }
    @Then("the start-and-end weeks of the project can not be updated")
    public void the_start_and_end_weeks_of_the_project_can_not_be_updated() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
