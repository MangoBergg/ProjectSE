package dtu.example.strategies;

import java.util.Scanner;

import dtu.example.model.ErrorMessageHolder;
import dtu.example.model.ProjectManagementApp;
import dtu.example.interfaces.IEmployee;

public class CreateProjectStrategy implements UserActionStrategy {
    @Override
    public void execute(Scanner inputScanner, ProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage, IEmployee user) {
        try {
            System.out.println("Give a title for the project: ");
            projectManagementApp.getProjectFactory().createProject(inputScanner.nextLine());
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }
}
