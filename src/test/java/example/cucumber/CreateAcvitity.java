package example.cucumber;

import dtu.example.ui.ProjectManagementApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateAcvitity {

    ProjectManagementApp projectManagementApp = new ProjectManagementApp();
    private String projectName;
    private String activityName;
    private String errorMessage;

    @Given("the employee selects a project named {string} from the list of projects")
    public void theEmployeeSelectsAProjectNamedFromTheListOfProjects(String string) throws Exception {
        projectName = string;
        projectManagementApp.createProject(string);
        assertTrue(projectManagementApp.containsProject(projectName));
    }

    @When("a new activity named {string} is created")
    public void aNewActivityNamedIsCreated(String string){
        activityName = string;
            try {
            projectManagementApp.createActivity(string);
        } catch (Exception e) {
            errorMessage = e.getMessage();
    }
    }

    @Then("the activity is added to the list of activity")
    public void theActivityIsAddedToTheListOfActivity() {
        assertTrue(projectManagementApp.containsActivity(activityName));
    }


    @Given("the activity named {string} already exists in the list of activities for a project")
    public void theActivityNamedAlreadyExistsInTheListOfActivitiesForAProject(String string) throws Exception {
        projectManagementApp.createActivity(string);
    }

    @Then("an error message {string}")
    public void anErrorMessage(String string) {
        assertEquals(string, errorMessage);
    }



}
