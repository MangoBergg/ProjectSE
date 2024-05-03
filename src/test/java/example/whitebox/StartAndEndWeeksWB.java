package example.whitebox;

import dtu.example.ui.Activity;
import dtu.example.ui.ErrorMessageHolder;
import dtu.example.ui.Project;
import dtu.example.ui.ProjectManagementApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StartAndEndWeeksWB {

    ProjectManagementApp projectManagementApp = new ProjectManagementApp();
    private ErrorMessageHolder errorMessage;
    private Project project;
    private Activity activity1;
    private Activity activity2;

    public StartAndEndWeeksWB(ProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage) {
        this.projectManagementApp = projectManagementApp;
        this.errorMessage = errorMessage;
    }

    @Given("a project {string} exists")
    public void aProjectExists(String string) throws Exception {
        project = projectManagementApp.createProject(string);
    }

    @When("the project does not contain an activity")
    public void the_project_does_not_contain_an_activity() {
        assertEquals(0, projectManagementApp.activityList.size());
    }
    @Then("the project does not have start-and-end weeks")
    public void the_project_does_not_have_start_and_end_weeks() {
        assertEquals(0, project.getStartEndWeeks()[0]);
        assertEquals(0, project.getStartEndWeeks()[1]);
    }

    @Given("the project contains only the activity {string}")
    public void the_project_contains_only_the_activity(String string) throws Exception {
        activity1 = projectManagementApp.createActivity(string, project);
    }

    @When("the start-and-end weeks of the activity is set to start week {int} and end week {int}")
    public void the_start_and_end_weeks_of_the_activity_is_set_to_start_week_and_end_week(Integer int1, Integer int2) throws Exception {
        activity1.updateStartEndWeeks(12, 15);
        assertEquals(12, activity1.getStartEndWeeks()[0]);
        assertEquals(15, activity1.getStartEndWeeks()[1]);
    }

    @Then("the start-and-end weeks of the project is updated to start week {int} and end week {int}")
    public void the_start_and_end_weeks_of_the_project_is_updated_to_start_week_and_end_week(Integer int1, Integer int2) {
        assertEquals(12, project.getStartEndWeeks()[0]);
        assertEquals(15, project.getStartEndWeeks()[1]);
    }

    @When("the second activity {string} is created in the project")
    public void the_second_activity_is_created_in_the_project(String string) throws Exception {
        activity2 = projectManagementApp.createActivity(string, project);
    }

    @When("the start-and-end weeks of the new activity is set to start week {int} and end week {int}")
    public void the_start_and_end_weeks_of_the_new_activity_is_set_to_start_week_and_end_week(Integer int1, Integer int2) throws Exception {
        activity2.updateStartEndWeeks(11, 20);;
        assertEquals(11, activity2.getStartEndWeeks()[0]);
        assertEquals(20, activity2.getStartEndWeeks()[1]);
    }

    @Then("the start-and-end weeks of the project is updated to begin at the earliest start week {int} and end at the latest end week {int}")
    public void the_start_and_end_weeks_of_the_project_is_updated_to_begin_at_the_earliest_start_week_and_end_at_the_latest_end_week(Integer int1, Integer int2) {
        assertEquals(11, project.getStartEndWeeks()[0]);
        assertEquals(20, project.getStartEndWeeks()[1]);
    }



}
