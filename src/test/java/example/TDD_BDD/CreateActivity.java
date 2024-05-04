package example.TDD_BDD;

import dtu.example.interfaces.IProject;
import dtu.example.interfaces.IProjectManagementApp;
import dtu.example.model.ErrorMessageHolder;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateActivity {

    private IProjectManagementApp projectManagementApp;
    private String projectName;
    private String activityName;
    private ErrorMessageHolder errorMessage;
    private IProject testProject;

    public CreateActivity(IProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage) {
        this.projectManagementApp = projectManagementApp;
        projectManagementApp.getProjectRepository().reset();
        projectManagementApp.getActivityRepository().reset();
        projectManagementApp.getEmployeeRepository().reset();
        this.errorMessage = errorMessage;
    }


    @Given("the employee selects a project named {string} from the list of projects")
    public void theEmployeeSelectsAProjectNamedFromTheListOfProjects(String string) throws Exception {
        projectName = string;
        testProject = projectManagementApp.getProjectFactory().createProject(projectName);
        assertTrue(projectManagementApp.getProjectRepository().containsProject(string));
    }


    @When("the employee attemps to create an activity {string} when the activity already exists")
    public void the_employee_attemps_to_create_an_activity_when_the_activity_already_exists(String string) throws AssertionError {
        projectManagementApp.getActivityFactory().createActivity(string, testProject);
        try {
            projectManagementApp.getActivityFactory().createActivity(string, testProject);
        } catch (AssertionError e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @When("the employee attemps to create an activity {string} without a name")
    public void the_employee_attemps_to_create_an_activity_without_a_name(String string) throws AssertionError {
        try {
            projectManagementApp.getActivityFactory().createActivity("", testProject);
        } catch (AssertionError e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @When("a new activity named {string} is created")
    public void aNewActivityNamedIsCreated(String string){
        activityName = string;
        try {
            projectManagementApp.getActivityFactory().createActivity(string, testProject);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @Then("the activity is added to the list of activity")
    public void theActivityIsAddedToTheListOfActivity() {
        assertTrue(testProject.containsActivity(activityName));
    }



}