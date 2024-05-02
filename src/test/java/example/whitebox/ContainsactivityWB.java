package example.whitebox;

import java.util.ArrayList;
import java.util.List;

import dtu.example.ui.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class ContainsactivityWB {

    private Project project;
    private Activity activity;
    private boolean result;

    private String activityname;



    @Given("a new project")
    public void a_new_project() {
        project = new Project("project", 001);
    }

    @Given("the project contains the activity {string}")
    public void the_project_contains_the_activity(String string) {
        Activity activity = new Activity(string, project);
        project.addActivity(activity);
    }


    @And("the project contains no activity")
    public void the_project_contains_no_activity() {
        assertTrue(project.getActivityList().isEmpty());
    }

    @Then("the method should return false")
    public void the_method_should_return_false() {
        assertFalse(project.containsActivity("coding"));
    }

    @Then("the method should return true")
    public void the_method_should_return_true() {
        assertTrue(project.containsActivity("coding"));
    }
}

