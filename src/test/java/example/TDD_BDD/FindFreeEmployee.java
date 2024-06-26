package example.TDD_BDD;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import system.program.interfaces.IActivity;
import system.program.interfaces.IEmployee;
import system.program.interfaces.IProject;
import system.program.model.Activity;
import system.program.model.Developer;
import system.program.model.ErrorMessageHolder;
import system.program.model.Project;
import system.program.model.ProjectManagementApp;

import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;


public class FindFreeEmployee {

    private IEmployee testEmployee;
    private IProject testProject;
    private IActivity testActivity;
    private ProjectManagementApp projectManagementApp;
    private ErrorMessageHolder errorMessage;

    private List<IEmployee> testEmployeeList = new ArrayList<>();

    public FindFreeEmployee(ProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage) {
        this.projectManagementApp = projectManagementApp;
        projectManagementApp.getProjectRepository().reset();
        projectManagementApp.getActivityRepository().reset();
        projectManagementApp.getEmployeeRepository().reset();
        this.errorMessage = errorMessage;
    }

    @Given("{string} needs to assign employees to the activity {string} scheduled for weeks {int} to {int}")
    public void needsToAssignEmployeesToTheActivityScheduledForWeeksTo(String string, String string2, int int1, int int2) throws Exception {
        testEmployee = new Developer(string);
        testEmployee.registerAbsence("reason", int1, int2);
        testProject = new Project("Project", projectManagementApp.getProjectFactory().generateProjectNumber());
        testActivity = new Activity(string2, testProject);
        
        testActivity.getStartEndWeeks()[0] = int1;
        testActivity.getStartEndWeeks()[1] = int2;
    }

    @When("{string} prompts a list of free employees for the activity {string}")
    public void promptsAListOfFreeEmployeesForTheActivity(String string, String string2) {
        try {
            testEmployeeList = projectManagementApp.findFreeEmployees(testActivity);
        } catch (AssertionError e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @Then("a list is returned containing employees who are not absent in week {int} to {int}. Not assigned to {string}")
    public void aListIsReturnedContainingEmployeesWhoAreNotAbsentInWeekToNotAssignedTo(Integer int1, Integer int2, String string) {
        assertFalse(testEmployeeList.contains(testEmployee));
    }
}