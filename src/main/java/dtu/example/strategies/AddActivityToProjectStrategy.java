package dtu.example.strategies;

import java.util.Scanner;

import dtu.example.model.ErrorMessageHolder;
import dtu.example.model.ProjectManagementApp;
import dtu.example.interfaces.IEmployee;
import dtu.example.interfaces.IProject;
import dtu.example.model.Printer;

public class AddActivityToProjectStrategy implements UserActionStrategy {
    @Override
    public void execute(Scanner inputScanner, ProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage, IEmployee user) {
        try {
            System.out.println("What project do you want to add an activity?: ");
            IProject project = projectManagementApp.getProjectRepository().getProjectList().get(Integer.parseInt(inputScanner.nextLine()) - 1);
            Printer.clearScreen();
            Printer.displayActivityOverview(project.getActivityList());
            System.out.println("What do you want to name the activity to be added to: '" + project.getName() + "'?");
            projectManagementApp.getActivityFactory().createActivity(inputScanner.nextLine(), project);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }
}
