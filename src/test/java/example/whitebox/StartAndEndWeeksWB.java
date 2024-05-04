package example.whitebox;

import dtu.example.ui.Activity;
import dtu.example.ui.ErrorMessageHolder;
import dtu.example.ui.Project;
import dtu.example.ui.ProjectManagementApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StartAndEndWeeksWB {

    ProjectManagementApp projectManagementApp = new ProjectManagementApp();
    private ErrorMessageHolder errorMessage;
    private Project project;
    private Activity activity;

    public StartAndEndWeeksWB(ProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage) {
        this.projectManagementApp = projectManagementApp;
        this.errorMessage = errorMessage;
    }

    @Given("a project {string} exists")
    public void aProjectExists(String string) {
        project = new Project(string, 24001);;
    }


    @Given("it contains the activity {string}")
    public void it_contains_the_activity(String string) throws Exception {
        try {
            activity = projectManagementApp.createActivity(string, project);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }


    @When("the start week {int} is after the end week  {int}")
    public void the_start_week_is_after_the_end_week(Integer int1, Integer int2) throws Exception {
        try {
            activity.updateStartEndWeeks(4, 2);
        } catch (AssertionError e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }



    @When("the start week is {int} and the end week is {int}")
    public void the_start_week_is_and_the_end_week_is(Integer int1, Integer int2) throws Exception {
        try {
            activity.updateStartEndWeeks(55, 69);
        } catch (AssertionError e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }


    @Then("the error message {string} is given")
    public void the_error_message_is_given(String string) {
        assertEquals(string, errorMessage.getErrorMessage());
    }


    @When("the start-and-end weeks of the activity is set to start week {int} and end week {int}")
    public void the_start_and_end_weeks_of_the_activity_is_set_to_start_week_and_end_week(Integer int1, Integer int2) throws Exception {
        activity.updateStartEndWeeks(2, 4);
        assertEquals(2, project.getStartEndWeeks()[0]);
        assertEquals(4, project.getStartEndWeeks()[1]);
    }

    @Then("the start-and-end weeks of the project is updated to start week {int} and end week {int}")
    public void the_start_and_end_weeks_of_the_project_is_updated_to_start_week_and_end_week(Integer int1, Integer int2) {
        assertEquals(2, project.getStartEndWeeks()[0]);
        assertEquals(4, project.getStartEndWeeks()[1]);
    }

}
