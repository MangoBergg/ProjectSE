package system.program.strategies;

import java.util.Scanner;

import system.program.interfaces.IEmployee;
import system.program.interfaces.IProject;
import system.program.model.ErrorMessageHolder;
import system.program.model.Printer;
import system.program.model.ProjectManagementApp;

public class UpdateProjectManagerStrategy implements UserActionStrategy {
    @Override
    public void execute(Scanner inputScanner, ProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage, IEmployee user) {
        try {
            System.out.println("What project do you want to update the project manager?: ");
            IProject project = projectManagementApp.getProjectRepository().getProjectList().get(Integer.parseInt(inputScanner.nextLine()) - 1);
            Printer.clearScreen();
            Printer.displayEmployeeOverview(projectManagementApp.getEmployeeRepository().getEmployeeList());
            System.out.println("What employee should be the project manager for the project: '" + project.getName() + "'?");
            IEmployee employee = projectManagementApp.getEmployeeRepository().getEmployeeList().get(Integer.parseInt(inputScanner.nextLine()) - 1);
            project.setProjectManager(employee);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }
}
