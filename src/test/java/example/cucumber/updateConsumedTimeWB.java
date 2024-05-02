package example.cucumber;

import java.util.ArrayList;
import java.util.List;

import dtu.example.ui.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class updateConsumedTimeWB {

    private Employee employee;

    private Project project;
    private Activity testActivity;
    private List<ConsumedTime> consumedTimeList;
    private Exception thrownException;

    @Given("^an activity with no consumed time$")
    public void an_activity_with_no_consumed_time() throws Throwable {
        project = new Project("Projekt", 1)
        testActivity = new Activity("Test Activity", project);
    }

    @Given("^an activity with initial consumed time of (\\d+\\.\\d+) hours$")
    public void an_activity_with_initial_consumed_time_of_hours(double hours) throws Throwable {
        testActivity = new Activity("Test Activity");
        consumedTimeList = new ArrayList<>();
        consumedTimeList.add(new ConsumedTime(hours, testActivity));
        testActivity.updateConsumedTime(hours); // Assuming this method is to increment the internal state of the activity
    }

    @When("^I try to update the consumed time with (-?\\d+\\.\\d+) hours$")
    public void i_try_to_update_the_consumed_time_with_hours(double hours) throws Throwable {
        try {
            updateConsumedTime(hours, testActivity);
        } catch (Exception e) {
            thrownException = e;
        }
    }

    @Then("^I receive an error \"([^\"]*)\"$")
    public void i_should_receive_an_error(String expectedMessage) throws Throwable {
        assertNotNull("Expected an exception to be thrown", thrownException);
        assertEquals("Exception message should match", expectedMessage, thrownException.getMessage());
    }

    @Then("^the total consumed time for the activity should be (\\d+\\.\\d+) hours$")
    public void the_total_consumed_time_for_the_activity_should_be_hours(double expectedHours) throws Throwable {
        double totalHours = 0.0;
        for (ConsumedTime ct : consumedTimeList) {
            if (ct.activity.getName().equals(testActivity.getName())) {
                totalHours += ct.time;
            }
        }
        assertEquals("Total hours should match expected hours", expectedHours, totalHours, 0.01);
    }
}