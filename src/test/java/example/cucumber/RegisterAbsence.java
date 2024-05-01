package example.cucumber;

import dtu.example.ui.Absence;
import dtu.example.ui.Employee;
import dtu.example.ui.ProjectManagementApp;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;


public class RegisterAbsence {

    private Employee employee;
    private ErrorMessageHolder errorMessage;


    public RegisterAbsence(ProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage) {
        this.errorMessage = errorMessage;
    }

    @When("the employee {string} attempts to register absence with the reason {string}, and a start week {int} that is before the end week {int}")
    public void theEmployeeAttemptsToRegisterAbsenceWithTheReasonAndAStartWeekThatIsBeforeTheEndWeek(String string, String string2, Integer int1, Integer int2) {
        employee = new Employee(string);
        try {
            employee.registerAbsence(string2, int1, int2);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @When("the employee {string} attempts to register absence with the reason {string}, and a starting week {int} that is after the end week {int}")
    public void theEmployeeAttemptsToRegisterAbsenceWithTheReasonAndAStartingWeekThatIsAfterTheEndWeek(String string, String string2, Integer int1, Integer int2) {
        employee = new Employee(string);
        try {
            employee.registerAbsence(string2, int1, int2);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @When("the employee {string} attempts to register absence with the reason {string}, and a starting week {int} that is before the end date {int}")
    public void theEmployeeAttemptsToRegisterAbsenceWithTheReasonAndAStartingWeekThatIsBeforeTheEndDate(String string, String string2, int int1, int int2) {
        employee = new Employee(string);
        try {
            employee.registerAbsence(string2, int1, int2);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @Then("the employee is registered as absent from the start week {int} till the end week {int} because of {string}")
    public void theEmployeeIsRegisteredAsAbsentFromTheStartWeekTillTheEndWeekBecauseOf(int int1, int int2, String string) {
        Absence absence = employee.getAbsence().get(0);
        int startWeek = absence.absenceWeeks[0];
        int endWeek = absence.absenceWeeks[1];
        String reason = absence.absenceReason;
        assertTrue(startWeek == int1 && endWeek == int2 && reason.equals(string));
    }
}