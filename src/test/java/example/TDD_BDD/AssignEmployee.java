package example.TDD_BDD;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import system.program.interfaces.IActivity;
import system.program.interfaces.IEmployee;
import system.program.interfaces.IProject;
import system.program.interfaces.IProjectManagementApp;
import system.program.model.Developer;
import system.program.model.ErrorMessageHolder;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AssignEmployee {

    private IActivity testActivity;
    private IProject testProject;
    private IEmployee employee;
    private String projectName;
    private String activityName;
    private ErrorMessageHolder errorMessage;
    private IProjectManagementApp projectManagementApp;


    public AssignEmployee(IProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage) {
        this.projectManagementApp = projectManagementApp;
        projectManagementApp.getProjectRepository().reset();
        projectManagementApp.getActivityRepository().reset();
        projectManagementApp.getEmployeeRepository().reset();
        this.errorMessage = errorMessage;
    }

    @Given("the employee attempts to assign an employee {string} to the activity {string} in the project {string}")
    public void the_employee_attempts_to_assign_an_employee_to_the_activity_in_the_project(String string, String string2, String string3) throws Exception {
        employee = new Developer("test");
        activityName = string2;
        projectName = string3;
        testProject = projectManagementApp.getProjectFactory().createProject(projectName);
        testActivity = projectManagementApp.getActivityFactory().createActivity(activityName, testProject);
        try {
            testActivity.assignEmployee(employee);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @Then("the employee is assigned to the activity")
    public void the_employee_is_assigned_to_the_activity() {
        assertTrue(testActivity.containsAssignedEmployee(employee));
    }

    @When("the employee {string} is already assigned to the activity")
    public void the_employee_is_already_assigned_to_the_activity(String string) {
        try {
            testActivity.assignEmployee(employee);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

}