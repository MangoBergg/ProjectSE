package example.cucumber;


import dtu.example.ui.ProjectManagementApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;

public class Login {

    ProjectManagementApp projectManagementApp = new ProjectManagementApp();


    public Login(ProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage) {
        this.projectManagementApp = projectManagementApp;
    }

    @Given("an employee is logged into the system")
    public void an_employee_is_logged_into_the_system() {
        assertTrue(projectManagementApp.isLoggedIn());
    }

    @When("the employee's {string} is created")
    public void the_employee_s_is_created(String string) throws Exception {
        projectManagementApp.createEmployee(string);
    }

    @Then("the employee's {string} is added to the list of employees")
    public void the_employee_s_is_added_to_the_list_of_employees(String string) {
        assertTrue(projectManagementApp.containsEmployee(string));
    }

}
