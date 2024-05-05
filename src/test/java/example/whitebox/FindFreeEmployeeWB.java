package example.whitebox;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import system.program.interfaces.IActivity;
import system.program.interfaces.IEmployee;
import system.program.interfaces.IProject;
import system.program.model.Activity;
import system.program.model.Developer;
import system.program.model.ErrorMessageHolder;
import system.program.model.ProjectManagementApp;

public class FindFreeEmployeeWB {
    ProjectManagementApp projectManagementApp = new ProjectManagementApp();
    private IProject testProject;
    private IActivity testActivity;
    private IEmployee testEmployee;
    private List<IEmployee> employeeList;
    private ErrorMessageHolder errorMessage;

    public FindFreeEmployeeWB(ProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage) {
        this.projectManagementApp = projectManagementApp;
        projectManagementApp.getProjectRepository().reset();
        projectManagementApp.getActivityRepository().reset();
        projectManagementApp.getEmployeeRepository().reset();
        this.errorMessage = errorMessage;
    }

    @When("the employee searches for available employees for an activity {string} in an empty employeeList")
    public void the_employee_searches_for_available_employees_for_an_activity_in_an_empty_employee_list(String string) throws Exception {
        testProject = projectManagementApp.getProjectFactory().createProject("project");
        testActivity = new Activity(string, testProject);
        testEmployee = new Developer("huba");

        try {
            employeeList = projectManagementApp.findFreeEmployees(testActivity);
        } catch (AssertionError e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }



    @When("the employee searches for available employees for an activity {string} in an employeeList that is not empty")
    public void the_employee_searches_for_available_employees_for_an_activity_in_an_employee_list_that_is_not_empty(String string) throws Exception {
        testProject = projectManagementApp.getProjectFactory().createProject("project");
        testActivity = new Activity(string, testProject);
        testEmployee = new Developer("huba");

        try {
            projectManagementApp.getEmployeeRepository().addEmployee(testEmployee);
            employeeList = projectManagementApp.findFreeEmployees(testActivity);
        } catch (AssertionError e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @When("the activity doesnt have defined weeks")
    public void the_activity_doesnt_have_defined_weeks() {
        assertEquals(0, testActivity.getStartEndWeeks()[0]);
        assertEquals(0, testActivity.getStartEndWeeks()[1]);
    }

    @When("the employee searches for available employees for an activity {string} with start and end weeks in an employeeList that is not empty")
    public void the_employee_searches_for_available_employees_for_an_activity_with_start_and_end_weeks_in_an_employee_list_that_is_not_empty(String string) throws Exception {
        testProject = projectManagementApp.getProjectFactory().createProject("project");
        testActivity = new Activity(string, testProject);
        testActivity.updateStartEndWeeks(1, 4);
        testEmployee = new Developer("huba");
        testEmployee.registerAbsence("reason", 1, 4);

        try {
            projectManagementApp.getEmployeeRepository().addEmployee(testEmployee);
            employeeList = projectManagementApp.findFreeEmployees(testActivity);
        } catch (AssertionError e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @When("no available employee is found for the activity")
    public void noAvailableEmployeeIsFoundForTheActivity() {
        assertNull(employeeList);
    }

    @When("the employee searches for available employees for an activity {string}")
    public void theEmployeeSearchesForAvailableEmployeesForAnActivity(String string) throws Exception {
        testProject = projectManagementApp.getProjectFactory().createProject("project");
        testActivity = new Activity(string, testProject);
        testEmployee = new Developer("huba");
        testActivity.updateStartEndWeeks(1, 4);
        testEmployee.registerAbsence("reason", 5, 7);

        try {
            projectManagementApp.getEmployeeRepository().addEmployee(testEmployee);
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