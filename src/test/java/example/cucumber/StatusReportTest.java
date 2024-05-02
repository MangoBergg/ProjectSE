package example.cucumber;

import static org.junit.Assert.assertNotNull;

import dtu.example.ui.Activity;
import dtu.example.ui.Employee;
import dtu.example.ui.ErrorMessageHolder;
import dtu.example.ui.Project;
import dtu.example.ui.ProjectManagementApp;
import dtu.example.ui.StatusReport;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StatusReportTest {
    ProjectManagementApp projectManagementApp = new ProjectManagementApp();
    
    private Project testProject;
    private Activity testActivity;
    private Employee testEmployee;

    public StatusReportTest(ProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage) {
        this.projectManagementApp = projectManagementApp;
    }

    @When("the employee {string} prompts a status report for the project {string}")
    public void theEmployeePromptsAStatusReportForTheProject(String string, String string2) throws Exception {
        testProject = projectManagementApp.createProject(string2);
        testActivity = projectManagementApp.createActivity("testActivity", testProject);
        testEmployee = new Employee(string);
        testActivity.updateBudgetedTime(20);
        testActivity.updateConsumedTime(15);
        testEmployee.addStatusReport(new StatusReport(testProject));
    }

    @Then("a status report for the project {string} is returned to the employee {string} with valuable information.")
    public void aStatusReportForTheProjectIsReturnedToTheEmployeeWithValuableInformation(String string, String string2) {
        StatusReport statusReport = testEmployee.getStatusReports().get(0);
        assertNotNull(statusReport);
    }
}
