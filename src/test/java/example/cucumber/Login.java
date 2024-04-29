package example.cucumber;


import dtu.example.ui.ProjectManagementApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Login {
    
    ProjectManagementApp projectManagementApp = new ProjectManagementApp();


    public Login(ProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage) {
        this.projectManagementApp = projectManagementApp;
    }


    @Given("the employee {string} logs into the system for the first time")
    public void the_employee_logs_into_the_system_for_the_first_time(String string) {
        assertFalse(projectManagementApp.containsEmployee(string));
    }

    @When("the employee {string} is created")
    public void the_employee_is_created(String string) {
        projectManagementApp.createEmployee(string);
    }

    @Then("the list of employees contains {string}")
    public void the_list_of_employees_contains(String string) {
        projectManagementApp.createEmployee(string);
        assertTrue(projectManagementApp.containsEmployee(string));
    }


    @Then("the employee logs into the system")
    public void the_employee_logs_into_the_system() {
        assertTrue(projectManagementApp.isLoggedIn());
    }

}
