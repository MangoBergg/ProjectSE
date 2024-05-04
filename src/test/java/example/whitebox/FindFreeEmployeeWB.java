package example.whitebox;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import dtu.example.interfaces.IActivity;
import dtu.example.interfaces.IProject;
import dtu.example.ui.Activity;
import dtu.example.ui.Developer;
import dtu.example.ui.Employee;
import dtu.example.ui.ErrorMessageHolder;
import dtu.example.ui.ProjectManagementApp;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FindFreeEmployeeWB {
    ProjectManagementApp projectManagementApp = new ProjectManagementApp();
    private IProject testProject;
    private IActivity testActivity;
    private Employee testEmployee;
    private List<Employee> employeeList;
    private ErrorMessageHolder errorMessage;

    public FindFreeEmployeeWB(ProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage) {
        this.projectManagementApp = projectManagementApp;
        this.errorMessage = errorMessage;
    }

    @When("the employee searches for available employees for an activity {string} and the employeeList is empty")
    public void theEmployeeSearchesForAvailableEmployeesForAnActivityAndTheEmployeeListIsEmpty(String string) throws Exception {
        testProject = projectManagementApp.createProject("project");
        testActivity = new Activity(string, testProject);
        testEmployee = new Developer("huba");

        try {
            employeeList = projectManagementApp.findFreeEmployees(testActivity);
        } catch (AssertionError e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }
    
    @When("the employee searches for available employees for an activity {string} and the employeeList is not empty")
    public void theEmployeeSearchesForAvailableEmployeesForAnActivityAndTheEmployeeListIsNotEmpty(String string) throws Exception {
        testProject = projectManagementApp.createProject("project");
        testActivity = new Activity(string, testProject);
        testActivity.updateStartEndWeeks(1, 4);
        testEmployee = new Developer("huba");
        testEmployee.registerAbsence("reason", 1, 4);

        try {
            projectManagementApp.employeeList.add(testEmployee);
            employeeList = projectManagementApp.findFreeEmployees(testActivity);
        } catch (AssertionError e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @When("the employee searches for available employees for an activity {string} and the employeeList is not empty and the activity doesnt have defined weeks")
    public void theEmployeeSearchesForAvailableEmployeesForAnActivityAndTheEmployeeListIsNotEmptyAndTheActivityDoesntHaveDefinedWeeks(String string) throws Exception {
        testProject = projectManagementApp.createProject("project");
        testActivity = new Activity(string, testProject);
        testEmployee = new Developer("huba");

        try {
            projectManagementApp.employeeList.add(testEmployee);
            employeeList = projectManagementApp.findFreeEmployees(testActivity);
        } catch (AssertionError e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @When("the activity doesn't have defined weeks")
    public void theActivityDoesnTHaveDefinedWeeks() {
        testActivity.getStartEndWeeks()[0] = 0;
        testActivity.getStartEndWeeks()[1] = 0;
    }

    @When("no available employee is found for the activity")
    public void noAvailableEmployeeIsFoundForTheActivity() {
        assertNull(employeeList);
    }

    @When("the employee searches for available employees for an activity {string}")
    public void theEmployeeSearchesForAvailableEmployeesForAnActivity(String string) throws Exception {
        testProject = projectManagementApp.createProject("project");
        testActivity = new Activity(string, testProject);
        testEmployee = new Developer("huba");
        testActivity.updateStartEndWeeks(1, 4);
        testEmployee.registerAbsence("reason", 5, 7);

        try {
            projectManagementApp.employeeList.add(testEmployee);
            employeeList = projectManagementApp.findFreeEmployees(testActivity);
        } catch (AssertionError e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }
    
    @Then("a list containing the employee {string} is returned")
    public void aListContainingTheEmployeeIsReturned(String string) {
        assertTrue(employeeList.contains(testEmployee));
    }

    @Then("an error message {string} is given")
    public void anErrorMessageIsGiven(String string) {
        assertEquals(string, errorMessage.getErrorMessage());
    }
}