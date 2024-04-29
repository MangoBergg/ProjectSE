package example.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StatusReport {

    @Given("the employee {string} prompts a status report for the project {string}")
    public void the_employee_prompts_a_status_report_for_the_project(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the status report for the project is returned")
    public void the_status_report_for_the_project_is_returned() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the status report contains the budgeted for each activity")
    public void the_status_report_contains_the_budgeted_for_each_activity() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the status report contains the time consumed on each activity")
    public void the_status_report_contains_the_time_consumed_on_each_activity() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
