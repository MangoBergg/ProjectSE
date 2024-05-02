package example.cucumber;

import static org.junit.Assert.assertFalse;

import dtu.example.ui.Activity;
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
    private StatusReport testStatusReport;

    public StatusReportTest(ProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage) {
        this.projectManagementApp = projectManagementApp;
    }

    @When("an employee prompts a status report for the project {string}")
    public void theEmployeePromptsAStatusReportForTheProject(String string2) throws Exception {
        testProject = projectManagementApp.createProject(string2);
        testActivity = projectManagementApp.createActivity("testActivity", testProject);
        testActivity.updateBudgetedTime(20);
        testActivity.updateConsumedTime(15);
        testStatusReport = new StatusReport(testProject);
    }

    @Then("a status report for the project is returned to the employee with valuable information.")
    public void aStatusReportForTheProjectIsReturnedToTheEmployeeWithValuableInformation() {
        assertFalse(testStatusReport.report.isEmpty());
    }
}
