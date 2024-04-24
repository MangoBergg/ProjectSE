package example.cucumber;

import dtu.example.ui.Activity;
import dtu.example.ui.Project;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import dtu.example.ui.ProjectSystemApp;

import static org.junit.jupiter.api.Assertions.*;

public class CreateActivity {

    private ProjectSystemApp projectSystemApp;
    private Activity testActivity, testActivity1, testActivity2;

    private ErrorMessageHolder errorMessage;

    public CreateActivity() throws Exception {
        projectSystemApp = new ProjectSystemApp();
        errorMessage = new ErrorMessageHolder();
    }



    @When("the employee selects a project named {string}")
    public void theEmployeeSelectsAProjectNamed(String name) { assertTrue(true); }


    @When("the employee attempts to create a new activity named {string}")
    public void theEmployeeAttemptsToCreateANewActivityNamed(String name) throws Exception {
        testActivity = new Activity(name);
    }

    @When("no activity named {string} exists in the project")
    public void noActivityNamedExistsInTheProject(String name) {assertFalse(projectSystemApp.hasActivityWithName(testActivity));
    }

    @Then("the activity added to the project")
    public void theActivityAddedToTheProject() throws Exception {
        projectSystemApp.addActivity(testActivity);
    }



    @When("the activity named {string} already exists in the project")
    public void theActivityAlreadyExistsInTheProject(String name) {
        try {
            testActivity1 = new Activity("name");
            testActivity2 = new Activity("name");

            projectSystemApp.addActivity(testActivity1);
            projectSystemApp.addActivity(testActivity2);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    /*@Then("the activity is not created")
    public void theActivityIsNotCreated() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }*/


    /*@Then("an error message {string} is given")
    public void anErrorMessageStringIsGiven(String errorMessage) {
        assertEquals(errorMessage, this.errorMessage.getErrorMessage());
    }*/

}
