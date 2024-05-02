package example.whitebox;

import dtu.example.ui.Activity;
import dtu.example.ui.ErrorMessageHolder;
import dtu.example.ui.Project;
import dtu.example.ui.ProjectManagementApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChangeStartAndEndWeeksWB {

    ProjectManagementApp projectManagementApp = new ProjectManagementApp();
    private ErrorMessageHolder errorMessage;
    private Project testProject;
    private List<Project> projectList = new ArrayList<>();
    private Activity testActivity1;
    private List<Activity> activityList = new ArrayList<>();

    public ChangeStartAndEndWeeksWB(ProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage) {
        this.projectManagementApp = projectManagementApp;
        this.errorMessage = errorMessage;
    }

    @Given("a project {string} exists")
    public void aProjectExists(String string) throws Exception {
        testProject = new Project("testProject", 24001);
        assertTrue(projectManagementApp.containsProject("testProject"));
    }

    @Given("the project contains only the activity {string}")
    public void the_project_contains_only_the_activity(String string) throws Exception {

        Activity testActivity1 = new Activity(string, testProject);
        testProject.addActivity(testActivity1);
        assertTrue(testProject.containsActivity("testActivity1"));
    }
    @When("the start-and-end weeks of the activity is updated to start week {int} and end week {int}")
    public void the_start_and_end_weeks_of_the_activity_is_updated_to_start_week_and_end_week(Integer int1, Integer int2) throws Exception {
        //testActivity1.updateStartEndWeeks(12, 15);
         //assertTrue(testActivity1.getStartEndWeeks()[0] == 12 && testActivity1.getStartEndWeeks()[1] == 15);

    }
    @Then("the start-and-end weeks of the project is updated to start week {int} and end week {int}")
    public void the_start_and_end_weeks_of_the_project_is_updated_to_start_week_and_end_week(Integer int1, Integer int2) {
        //Assert.assertTrue(testActivity1.getParentProject().getStartEndWeeks()[0] == 12 && testActivity1.getParentProject().getStartEndWeeks()[1] == 15);
    }

}
