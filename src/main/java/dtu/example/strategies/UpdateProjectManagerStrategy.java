package dtu.example.strategies;

import java.util.Scanner;

import dtu.example.model.ErrorMessageHolder;
import dtu.example.model.ProjectManagementApp;
import dtu.example.interfaces.IEmployee;
import dtu.example.interfaces.IProject;
import dtu.example.model.Printer;

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
