package example.cucumber;

import dtu.example.ui.ProjectManagementApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateAcvitity {

    ProjectManagementApp projectManagementApp = new ProjectManagementApp();
    private String projectName;
    private String activityName;
    private String errorMessage;

    @Given("the employee selects a project named {string} from the list of projects")
    public void theEmployeeSelectsAProjectNamedFromTheListOfProjects(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("a new activity named {string} is created")
    public void aNewActivityNamedIsCreated(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the activity is added to the list of activity")
    public void theActivityIsAddedToTheListOfActivity() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
