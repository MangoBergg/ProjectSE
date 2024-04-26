package example.cucumber;

import dtu.example.ui.Project;
import dtu.example.ui.ProjectManagementApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Before;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateActivity {

    ProjectManagementApp projectManagementApp = new ProjectManagementApp();
    private String projectName;
    private String activityName;
    private String errorMessage;
    private Project testProject;



    @Given("the employee selects a project named {string} from the list of projects")
    public void theEmployeeSelectsAProjectNamedFromTheListOfProjects(String string) throws Exception {
        projectName = string;
        testProject = projectManagementApp.createProject(projectName);
        assertTrue(projectManagementApp.containsProject(string));
    }

    @When("a new activity named {string} is created")
    public void aNewActivityNamedIsCreated(String string){
        activityName = string;
        try {
            projectManagementApp.createActivity(string, testProject);
        } catch (Exception e) {
            errorMessage = e.getMessage();
        }
    }

    @Then("the activity is added to the list of activity")
    public void theActivityIsAddedToTheListOfActivity() {
        System.out.println(testProject.getName());
        assertTrue(testProject.containsActivity(activityName));
    }


    @Given("the activity named {string} already exists in the list of activities for a project")
    public void theActivityNamedAlreadyExistsInTheListOfActivitiesForAProject(String string) throws Exception {
        projectName = string;
        testProject = projectManagementApp.createProject(projectName);
        projectManagementApp.createActivity(string, testProject);

        try {
            projectManagementApp.createActivity(string, testProject);
        } catch (Exception e) {
            errorMessage = e.getMessage();
        }
    }

    @Then("an error message {string} is given")
    public void anErrorMessage(String string) {
        assertEquals(string, errorMessage);
    }



}
