package dtu.example.ui;

import java.util.Scanner;

import dtu.example.ui.Printer;
import dtu.example.ui.Project;
//import collection.ProjectActivity;
import dtu.example.ui.ProjectManagementSystem;
import dtu.example.ui.ProjectManagementSystem.State;

public class ProjectManagementSystemHelper {

    ProjectManagementSystem projectManagementSystem;
    Scanner inputScanner;

    public ProjectManagementSystemHelper(ProjectManagementSystem projectManagementSystem, Scanner inputScanner) {
        this.projectManagementSystem = projectManagementSystem;
        this.inputScanner = inputScanner;
    }

    public ProjectManagementSystemHelper() {

    }

    private int getInput(int numOptions) {
        int input = 0;
        do {
            try {
                input = inputScanner.nextInt();
                if (input >= 1 && input <= numOptions) {
                    return input;
                } else {
                    System.out.println("Invalid option. Please enter a number between 1 and " + numOptions + ".");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                inputScanner.next(); // Clear buffer
            }
        } while (true);
    }

    public void handleMainMenu() {
        System.out.println(Printer.BLUE + "Project Management System for Softwarehuset A/S - Version ");
        System.out.println(
                Printer.GREEN + "(1)" + Printer.YELLOW + " Open Project System \n" +
                        Printer.GREEN + "(2)" + Printer.YELLOW + " Open Time System \n" +
                        Printer.GREEN + "(3)" + Printer.YELLOW + " View maintenance log\n" +
                        Printer.GREEN + "(4)" + Printer.YELLOW + " Close System" +
                        Printer.RESET
        );


        switch (getInput(4)) { //getInput(number of cases) to validate that input is legal.
            case 1:
                projectManagementSystem.setState(State.PROJECT_SYSTEM);
                break;
            case 2:
                projectManagementSystem.setState(State.TIME_SYSTEM);
                break;
            case 3:
                projectManagementSystem.setState(State.VIEW_CHANGE_LOG);
                break;
            case 4:
                projectManagementSystem.shutdown();
                break;
        }
    }

//
//    public void handleProjectSystem() {
//        System.out.println(Printer.BLUE + "Project Sub-system" + Printer.RESET);
//        projectManagementSystem.projectSystem.displayProjectOverview(projectManagementSystem.user, projectManagementSystem.projectSystem.projects);
//        System.out.println(
//            Printer.GREEN + "(1) " + Printer.YELLOW + "Create a new project." + Printer.RESET + "\n" +
//            Printer.GREEN + "(2) " + Printer.YELLOW + "Open project" + Printer.RESET + "\n" +
//            Printer.GREEN + "(3) " + Printer.YELLOW + "Back" + Printer.RESET
//        );
//
//        switch(getInput(3)) { //getInput(number of cases) to validate that input is legal.
//            case 1:
//                Printer.clearScreen();
//                projectManagementSystem.projectSystem.displayProjectOverview(projectManagementSystem.user, projectManagementSystem.projectSystem.projects);
//                projectManagementSystem.projectSystem.createProject(projectManagementSystem, inputScanner);
//                break;
//            case 2:
//                projectManagementSystem.setState(State.OPENING_PROJECT);
//                break;
//            case 3:
//                projectManagementSystem.setState(State.MAIN_MENU);
//                break;
//        }
//    }
//
//    public void handleTimeSystem() {
//        //Empty so far
//    }
//
//    public void handleViewChangeLog() {
//        Printer.clearScreen();
//        projectManagementSystem.systemInfo.displayMaintenanceLog();
//        switch(getInput(1)) {
//            case 1:
//                projectManagementSystem.setState(State.MAIN_MENU);
//                break;
//        }
//    }
//
//    public void handleOpeningProject() {
//        System.out.println(Printer.BLUE + "Project Sub-system" + Printer.RESET);
//
//        //Take input to open the correct project:
//        String projectNumber;
//        boolean projectFound = false;
//        inputScanner.nextLine();
//
//        while (!projectFound) {
//            projectManagementSystem.projectSystem.displayProjectOverview(projectManagementSystem.user, projectManagementSystem.projectSystem.projects);
//            System.out.println(Printer.BLUE + "Provide the ID of the project you want to open (or type 'back' to go back):" + Printer.RESET);
//            projectNumber = inputScanner.nextLine();
//
//            if (projectNumber.equalsIgnoreCase("back")) {
//                projectManagementSystem.setState(State.PROJECT_SYSTEM);
//                return;
//            }
//
//            for (Project project : projectManagementSystem.projectSystem.projects) {
//                if (String.valueOf(project.projectNumber).equals(projectNumber)) {
//                    projectManagementSystem.openProject = project;
//                    projectFound = true;
//                    break;
//                }
//            }
//
//            if (!projectFound) {
//                Printer.clearScreen();
//                System.out.println(Printer.RED + "No project was found with that ID. Try again (or type 'back' to go back):" + Printer.RESET);
//            }
//        }
//
//        projectManagementSystem.setState(projectManagementSystem.openProject == null ? State.PROJECT_SYSTEM : State.OPEN_PROJECT);
//    }
//
//    public void handleOpenProject() {
//        projectManagementSystem.projectSystem.displayProjectDetails(projectManagementSystem.user, projectManagementSystem.openProject);
//        projectManagementSystem.projectSystem.displayActivityOverview(projectManagementSystem.user, projectManagementSystem.openProject);
//        System.out.println(
//            Printer.GREEN + "(1) " + Printer.YELLOW + "Create a new activity" + Printer.RESET + "\n" +
//            Printer.GREEN + "(2) " + Printer.YELLOW + "Open activity" + Printer.RESET + "\n" +
//            Printer.GREEN + "(3) " + Printer.YELLOW + "Back" + Printer.RESET
//        );
//
//        switch (getInput(3)) {
//            case 1: // Create Activity
//                Printer.clearScreen();
//                projectManagementSystem.projectSystem.createActivity(projectManagementSystem.openProject, inputScanner);
//                break;
//            case 2:
//                // Open activity
//                projectManagementSystem.setState(State.OPENING_ACTIVITY);
//                break;
//            case 3: // Back
//                projectManagementSystem.openProject = null;
//                projectManagementSystem.setState(State.PROJECT_SYSTEM);
//                break;
//        }
//    }
//
//    public void handleOpeningActivity() {
//        System.out.println(Printer.BLUE + "Project Sub-system" + Printer.RESET);
//
//        //Take input to open the correct project:
//        String activityName;
//        boolean activityFound = false;
//        inputScanner.nextLine();
//
//        while (!activityFound) {
//            projectManagementSystem.projectSystem.displayActivityOverview(projectManagementSystem.user, projectManagementSystem.openProject);
//            System.out.println(Printer.BLUE + "Provide the ID of the project you want to open (or type 'back' to go back):" + Printer.RESET);
//            activityName = inputScanner.nextLine();
//
//            if (activityName.equalsIgnoreCase("back")) {
//                projectManagementSystem.setState(State.OPEN_PROJECT);
//                return;
//            }
//
//            for (ProjectActivity projectActivity : projectManagementSystem.openProject.activities) {
//                if (String.valueOf(projectActivity.nameOfActivity).equals(activityName)) {
//                    projectManagementSystem.openActivity = projectActivity;
//                    activityFound = true;
//                    break;
//                }
//            }
//
//            if (!activityFound) {
//                Printer.clearScreen();
//                System.out.println(Printer.RED + "No activity was found with that name. Try again (or type 'back' to go back):" + Printer.RESET);
//            }
//        }
//
//        projectManagementSystem.setState(projectManagementSystem.openProject == null ? State.OPEN_PROJECT : State.OPEN_ACTIVITY);
//    }
//
//    public void handleOpenActiviy() {
//        projectManagementSystem.projectSystem.displayActivityDetails(projectManagementSystem.user, projectManagementSystem.openActivity);
//        projectManagementSystem.projectSystem.displayActivityOverview(projectManagementSystem.user, projectManagementSystem.openProject);
//        System.out.println(
//            Printer.GREEN + "(1) " + Printer.YELLOW + "Change start and end weeks" + Printer.RESET + "\n" +
//            Printer.GREEN + "(2) " + Printer.YELLOW + "Change budgeted time" + Printer.RESET + "\n" +
//            Printer.GREEN + "(3) " + Printer.YELLOW + "Back" + Printer.RESET
//        );
//
//        switch (getInput(3)) {
//            case 1:
//                Printer.clearScreen();
//                projectManagementSystem.projectSystem.changeStartEndWeeks(projectManagementSystem.openActivity, inputScanner);
//                break;
//            case 2:
//                Printer.clearScreen();
//                projectManagementSystem.projectSystem.changeBudgetTime(projectManagementSystem.openActivity, inputScanner);
//                break;
//            case 3: // Back
//                projectManagementSystem.openActivity = null;
//                projectManagementSystem.setState(State.OPEN_PROJECT);
//                break;
//        }
//    }
}