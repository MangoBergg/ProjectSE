package example.TDD_BDD;

import static org.junit.Assert.assertFalse;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import system.program.interfaces.IActivity;
import system.program.interfaces.IProject;
import system.program.interfaces.IProjectManagementApp;
import system.program.model.ErrorMessageHolder;
import system.program.model.ProjectManagementApp;

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
