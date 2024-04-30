package example.cucumber;

import dtu.example.ui.Activity;
import dtu.example.ui.Project;
import dtu.example.ui.ProjectManagementApp;
import dtu.example.ui.StatusReport;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class StatusReportTest {

    private Project testProject;
    private ProjectManagementApp projectManagementApp;
    private ErrorMessageHolder errorMessage;
    private String report;

    public StatusReportTest(ProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage) {
        this.projectManagementApp = projectManagementApp;
        this.errorMessage = errorMessage;
    }

    @When("a status report for the project is created")
    public void a_status_report_for_the_project_is_created() throws Exception {
        testProject = projectManagementApp.createProject("project");
        testProject.updateStatusReport();
        report = testProject.getStatusReport().getReport();

    }

    @Then("the status report for the project contains the budgeted time for each activity")
    public void the_status_report_for_the_project_contains_the_budgeted_time_for_each_activity() {
        assertTrue(report.contains("Budgeted time: %.2f hours\n"));
    }

    @Then("the status report for the project contains the time consumption for each activity")
    public void the_status_report_for_the_project_contains_the_time_consumption_for_each_activity() {
        assertTrue(report.contains("Time consumed: %.2f hours\n"));
    }

    @Then("the status report is given")
    public void the_status_report_is_given() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
