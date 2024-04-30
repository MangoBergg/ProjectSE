package example.cucumber;

import dtu.example.ui.Activity;
import dtu.example.ui.Project;
import dtu.example.ui.ProjectManagementApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class StatusReport {

    private Project testProject;
    private String statusReport;
    private ProjectManagementApp projectManagementApp;
    private ErrorMessageHolder errorMessage;

    public StatusReport(ProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage) {
        this.projectManagementApp = projectManagementApp;
        this.errorMessage = errorMessage;
    }

    @Given("the project contains a list of activities")
    public void the_project_contains_a_list_of_activities() {
        List<Activity> activities = Arrays.asList(
                new Activity("Coding", 2.0, 1.5),
                new Activity("Testing", 3.0, 2.5)
        );
    }

    @When("a status report for the project is created")
    public void a_status_report_for_the_project_is_created() throws Exception {
        testProject = projectManagementApp.createProject("project");
        statusReport = testProject.createStatusReport();
    }

    @Then("the status report for the project contains the budgeted time for each activity")
    public void the_status_report_for_the_project_contains_the_budgeted_time_for_each_activity() {
        assertTrue(statusReport.contains("Budgeted time: %.2f hours\n"));
    }

    @Then("the status report for the project contains the time consumption for each activity")
    public void the_status_report_for_the_project_contains_the_time_consumption_for_each_activity() {
        assertTrue(statusReport.contains("Time consumed: %.2f hours\n"));
    }

    @Then("the status report is given")
    public void the_status_report_is_given() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
