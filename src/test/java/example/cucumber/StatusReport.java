package example.cucumber;

import dtu.example.ui.Project;
import dtu.example.ui.ProjectManagementApp;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StatusReport {

    private Project testProject;
    private ProjectManagementApp projectManagementApp;
    private String activityName;
    private ErrorMessageHolder errorMessage;

    public StatusReport(ProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage) {
        this.projectManagementApp = projectManagementApp;
        this.errorMessage = errorMessage;
    }


    @When("a status report for the project {string} is created")
    public void a_status_report_for_the_project_is_created(String string) throws Exception {
        //testProject = projectManagementApp.createProject(string);
    }

    @Then("the status report for the project contains the budgeted time for each activity")
    public void the_status_report_for_the_project_contains_the_budgeted_time_for_each_activity() {
        // Loop through activities and budgeted time
        throw new io.cucumber.java.PendingException();
    }

    @Then("the status report for the project contains the time consumption for each activity")
    public void the_status_report_for_the_project_contains_the_time_consumption_for_each_activity() {
        // Loop through activities and consumed time
        throw new io.cucumber.java.PendingException();
    }

    @Then("the status report is given")
    public void the_status_report_is_given() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
