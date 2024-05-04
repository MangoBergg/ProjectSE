package example.TDD_BDD;

import dtu.example.ui.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertFalse;


public class FindFreeEmployee {

    private Employee testEmployee;
    private Project testProject;
    private Activity testActivity;
    private ProjectManagementApp projectManagementApp;
    private ErrorMessageHolder errorMessage;

    public FindFreeEmployee(ProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage) {
        this.projectManagementApp = projectManagementApp;
        this.errorMessage = errorMessage;
    }

    @Given("{string} needs to assign employees to the activity {string} scheduled for weeks {int} to {int}")
    public void needsToAssignEmployeesToTheActivityScheduledForWeeksTo(String string, String string2, int int1, int int2) throws Exception {
        testEmployee = new Developer(string);
        testEmployee.registerAbsence("reason", int1, int2);
        testProject = new Project("Project", projectManagementApp.generateProjectNumber());
        testActivity = new Activity(string2, testProject);
        
        testActivity.getStartEndWeeks()[0] = int1;
        testActivity.getStartEndWeeks()[1] = int2;
    }

    @When("{string} prompts a list of free employees for the activity {string}")
    public void promptsAListOfFreeEmployeesForTheActivity(String string, String string2) {
        try {
            projectManagementApp.findFreeEmployees(testActivity);
        } catch (AssertionError e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @Then("a list is returned containing employees who are not absent in week {int} to {int}. Not assigned to {string}")
    public void aListIsReturnedContainingEmployeesWhoAreNotAbsentInWeekToNotAssignedTo(Integer int1, Integer int2, String string) {
        assertFalse(projectManagementApp.employeeList.contains(testEmployee));
    }
}