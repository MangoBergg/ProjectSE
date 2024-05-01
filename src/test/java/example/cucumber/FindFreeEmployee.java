package example.cucumber;

import dtu.example.ui.Activity;
import dtu.example.ui.Employee;
import dtu.example.ui.Project;
import dtu.example.ui.ProjectManagementApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertFalse;


public class FindFreeEmployee {

    private Employee testEmployee;
    private Project testProject;
    private Activity testActivity;

    private ErrorMessageHolder errorMessage;
    private ProjectManagementApp projectManagementApp;


    public FindFreeEmployee(ProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage) {
        this.projectManagementApp = projectManagementApp;
        this.errorMessage = errorMessage;
    }

    @Given("{string} needs to assign employees to the activity {string} scheduled for weeks {int} to {int}")
    public void needsToAssignEmployeesToTheActivityScheduledForWeeksTo(String string, String string2, int int1, int int2) throws Exception {
        testEmployee = new Employee(string);
        testEmployee.registerAbsence("reason", int1, int2);

        testProject = new Project("Project", projectManagementApp.generateProjectNumber());
        testActivity = new Activity(string2, testProject);
        testActivity.updateStartEndWeeks(int1, int2);
    }

    @When("{string} prompts a list of free employees for the activity {string}")
    public void promptsAListOfFreeEmployeesForTheActivity(String string, String string2) throws Exception {
        projectManagementApp.findFreeEmployees(testActivity);
    }

    @Then("a list is returned containing employees who are not absent in week {int} to {int}. Not assigned to {string}")
    public void aListIsReturnedContainingEmployeesWhoAreNotAbsentInWeekToNotAssignedTo(Integer int1, Integer int2, String string) {
        assertFalse(projectManagementApp.employeeList.contains(testEmployee));
    }
}