package example.whitebox;

import dtu.example.ui.Activity;
import dtu.example.ui.ErrorMessageHolder;
import dtu.example.ui.Project;
import dtu.example.ui.ProjectManagementApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
    public void aProjectExists(String string) throws Exception {
        project = projectManagementApp.createProject(string);
    }

    @Given("the project contains only the activity {string}")
    public void the_project_contains_only_the_activity(String string) throws Exception {
        activity = projectManagementApp.createActivity(string, project);
    }

    @When("the start-and-end weeks of the activity is set to start week {int} and end week {int}")
    public void the_start_and_end_weeks_of_the_activity_is_set_to_start_week_and_end_week(Integer int1, Integer int2) throws Exception {
        try {
            activity.updateStartEndWeeks(int1, int2);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
        //activity.updateStartEndWeeks(12, 15);
        assertTrue((activity.getStartEndWeeks()[0] == 12) && (activity.getStartEndWeeks()[1] == 15));
    }

    @Then("the start-and-end weeks of the project is updated to start week {int} and end week {int}")
    public void the_start_and_end_weeks_of_the_project_is_updated_to_start_week_and_end_week(Integer int1, Integer int2) {
        assertEquals(true, activity.getParentProject().getStartEndWeeks()[0] == 12 && activity.getParentProject().getStartEndWeeks()[1] == 15);
    }

}
