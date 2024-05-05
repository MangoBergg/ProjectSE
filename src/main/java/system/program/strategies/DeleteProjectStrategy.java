package system.program.strategies;

import java.util.Scanner;

import system.program.interfaces.IEmployee;
import system.program.model.ErrorMessageHolder;
import system.program.model.ProjectManagementApp;

public class DeleteProjectStrategy implements UserActionStrategy {
    @Override
    public void execute(Scanner inputScanner, ProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage, IEmployee user) {
        try {
            System.out.println("Which project do you want to delete?: ");
            projectManagementApp.getProjectRepository().getProjectList().remove(Integer.parseInt(inputScanner.nextLine()) - 1);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }
}
