package example.cucumber;

import dtu.example.ui.Activity;
import dtu.example.ui.Employee;
import dtu.example.ui.Project;
import dtu.example.ui.ProjectManagementApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AssignEmployee {

    private Activity testActivity;
    private String employeeID;
    private ErrorMessageHolder errorMessage;


    public AssignEmployee(ErrorMessageHolder errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Given("the employee attempts to assign an employee {string} to the activity")
    public void theEmployeeAttemptsToAssignAnEmployeeToTheActivity(String string) throws Exception {
        employeeID = string;
        try {
            testActivity.assignEmployee(string);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }


        @When("the employee {string} is not already assigned to the activity")
        public void theEmployeeIsNotAlreadyAssignedToTheActivity(String string){
            assertTrue(testActivity.containsEmployee(employeeID));
        }

        @Then("the employee {string} is assigned to the activity {string}")
        public void theEmployeeIsAssignedToTheActivity(String string, String string1){
            // Write code here that turns the phrase above into concrete actions
            throw new io.cucumber.java.PendingException();
        }

    }

