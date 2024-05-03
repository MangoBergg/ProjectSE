package example.whitebox;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import dtu.example.ui.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterAbsenceWB {
    ProjectManagementApp projectManagementApp = new ProjectManagementApp();
    private Employee testEmployee;
    private ErrorMessageHolder errorMessage;

    public RegisterAbsenceWB(ProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage) {
        this.projectManagementApp = projectManagementApp;
        this.errorMessage = errorMessage;
    }

    @When("the employee tries to register absence with the reason {string} and weekStart is {int} and weekEnd is {int}")
    public void theEmployeeTriesToRegisterAbsenceWithTheReasonAndWeekStartIsAndWeekEndIs(String string, int int1, int int2) {
        testEmployee = new Employee("huba");
        try {
            testEmployee.registerAbsence(string, int1, int2);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @Then("an error message {string} is given")
    public void anErrorMessageIsGiven(String string) {
        assertEquals(string, errorMessage.getErrorMessage());
    }

    @Then("the employee has registered absence")
    public void theEmployeeHasRegisteredAbsence() {
        assertNotNull(testEmployee.getAbsence().get(0));
    }
}