package example.cucumber;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StatusReport {

    @When("the employee prompts a status report for the project {string}")
    public void the_employee_prompts_a_status_report_for_the_project(String string) {
        // UI something eller hvad?
        throw new io.cucumber.java.PendingException();
    }

    @Then("a status report for the project is created")
    public void a_status_report_for_the_project_is_created() {
        // Create status report
        throw new io.cucumber.java.PendingException();
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
}
