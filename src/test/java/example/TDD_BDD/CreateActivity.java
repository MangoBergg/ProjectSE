package example.TDD_BDD;

import dtu.example.interfaces.IProject;
import dtu.example.ui.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateActivity {

    private ProjectManagementApp projectManagementApp;
    private String projectName;
    private String activityName;
    private ErrorMessageHolder errorMessage;
    private IProject testProject;

    public CreateActivity(ProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage) {
        this.projectManagementApp = projectManagementApp;
        this.errorMessage = errorMessage;
    }


    @Given("the employee selects a project named {string} from the list of projects")
    public void theEmployeeSelectsAProjectNamedFromTheListOfProjects(String string) throws Exception {
        projectName = string;
        testProject = projectManagementApp.createProject(projectName);
        assertTrue(projectManagementApp.containsProject(string));
    }

    
    @Given("the activity named {string} already exists in the list of activities for a project")
    public void theActivityNamedAlreadyExistsInTheListOfActivitiesForAProject(String string) throws Exception {
        projectManagementApp.createActivity(string, testProject);
        try {
            projectManagementApp.createActivity(string, testProject);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @When("the employee tries to make an activity with an empty name {string}")
    public void the_employee_tries_to_make_an_activity_with_an_empty_name(String string) throws Exception {
        try {
            projectManagementApp.createActivity("", testProject);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @When("a new activity named {string} is created")
    public void aNewActivityNamedIsCreated(String string){
        activityName = string;
        try {
            projectManagementApp.createActivity(string, testProject);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @Then("the activity is added to the list of activity")
    public void theActivityIsAddedToTheListOfActivity() {
        assertTrue(testProject.containsActivity(activityName));
    }
}