package example.TDD_BDD;

import static org.junit.Assert.assertFalse;

import dtu.example.interfaces.IActivity;
import dtu.example.interfaces.IProject;
import dtu.example.interfaces.IProjectManagementApp;
import dtu.example.model.ErrorMessageHolder;
import dtu.example.model.ProjectManagementApp;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StatusReportTest {
    IProjectManagementApp projectManagementApp = new ProjectManagementApp();
    
    private IProject testProject;
    private IActivity testActivity;
    private String statusReport;

    public StatusReportTest(IProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage) {
        this.projectManagementApp = projectManagementApp;
        projectManagementApp.getProjectRepository().reset();
        projectManagementApp.getActivityRepository().reset();
        projectManagementApp.getEmployeeRepository().reset();
    }

    @When("an employee prompts a status report for the project {string}")
    public void theEmployeePromptsAStatusReportForTheProject(String string2) throws Exception {
        testProject = projectManagementApp.getProjectFactory().createProject(string2);
        testActivity = projectManagementApp.getActivityFactory().createActivity("testActivity", testProject);
        testActivity.updateBudgetedTime(20);
        testActivity.updateConsumedTime(15);
        statusReport = testProject.makeReport();
    }

    @Then("a status report for the project is returned to the employee with valuable information.")
    public void aStatusReportForTheProjectIsReturnedToTheEmployeeWithValuableInformation() {
        assertFalse(statusReport.isEmpty());
    }
}
