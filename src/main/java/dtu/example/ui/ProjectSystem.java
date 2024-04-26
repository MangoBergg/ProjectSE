package dtu.example.ui;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dtu.example.ui.Printer;
import dtu.example.ui.Project;
//import collection.ProjectActivity;
import dtu.example.ui.ProjectSystemHelper;

public class ProjectSystem extends ProjectSystemHelper {

//    public TimeSystem timeSystem;
    public List<Project> projects = new ArrayList<>();

    public void createProject(ProjectManagementSystem projectManagementSystem, Scanner inputScanner) {
        String nameOfProject = "";
        inputScanner.nextLine();
        boolean uniqueName;

        do {
            uniqueName = true;
            System.out.println(Printer.BLUE + "Provide a name for the new project" + Printer.RESET);
            nameOfProject = inputScanner.nextLine();

            if (nameOfProject.isBlank()) {
                Printer.clearScreen();
                System.out.println(Printer.RED + "You need to specify a name for the project - ");
                uniqueName = false;
            }

            if (!nameOfProject.matches("^[a-zA-Z0-9]{4,16}$")) { //Consists of 4 to 16 "normal"-characters
                Printer.clearScreen();
                System.out.println(Printer.RED + "Invalid name for the project - Project names should be 4-16 characters long without special characters.");
                uniqueName = false;
            }

//            for (Project project : projectManagementSystem.projectSystem.projects) {
//                if (project.name.equals(nameOfProject)) {
//                    Printer.clearScreen();
//                    System.out.println(Printer.RED + "A project named '" + nameOfProject + "' already exists in the system - ");
//                    uniqueName = false;
//                    break;
//                }
//            }
        } while (!uniqueName);

//        projects.add(new Project(nameOfProject, projectManagementSystem.generateProjectNumber()));
    }

    public void createActivity(Project openProject, Scanner inputScanner) {
        String nameOfActivity = "";
        inputScanner.nextLine();
        boolean uniqueName;

        do {
            uniqueName = true;
            System.out.println(Printer.BLUE + "Provide a name for the new activity" + Printer.RESET);
            nameOfActivity = inputScanner.nextLine();

            if (nameOfActivity.isBlank()) {
                Printer.clearScreen();
                System.out.println(Printer.RED + "You need to specify a name for the activity - ");
                uniqueName = false;
            }

//            for (ProjectActivity activity : openProject.activities) {
//                if (activity.nameOfActivity.equals(nameOfActivity)) {
//                    Printer.clearScreen();
//                    System.out.println(Printer.RED + "An activity named '" + nameOfActivity + "' already exists in the system - ");
//                    uniqueName = false;
//                    break;
//                }
//            }
        } while(!uniqueName);

//        openProject.activities.add(new ProjectActivity(openProject, nameOfActivity));
    }

//    public void changeBudgetTime(ProjectActivity openActivity, Scanner inputScanner) {
//
//        inputScanner.nextLine();
//
//        while (true) {
//            System.out.println("Please input budgeted time in increments of 0.5 separated by a '.'");
//            String input = inputScanner.nextLine();
//
//            // Matches our format.
//            if (input.matches("\\d+\\.0|\\d+\\.5")) { // REGEX FROM CHATGPT FROM PROMPT:
//                // ^^
//                //PROMPT: Write me regex to match "number1.number2" where number2 = 5 and number1 is any number.
//
//                double budgetedTime = Double.parseDouble(input);
//                openActivity.budgetTime = budgetedTime;
//                System.out.println("Budgeted time set to: " + budgetedTime);
//                break;
//            } else {
//                System.out.println("Invalid input. Please ensure your number is in increments of 0.5");
//            }
//        }
//    }


//    public void changeStartEndWeeks(ProjectActivity openActivity, Scanner inputScanner) {
//        inputScanner.nextLine();
//
//        while (true) {
//            System.out.println(Printer.BLUE + "Please input start and end weeks seperated by a comma");
//            String[] input = inputScanner.nextLine().split(",");
//
//            if (input.length != 2) {
//                System.out.println(Printer.RED + "Invalid input. Input should be two numbers seperated by a comma.");
//                continue;
//            }
//
//            try {
//                int start = Integer.parseInt(input[0].trim());
//                int end = Integer.parseInt(input[1].trim());
//
//                if (start > end) {
//                    System.out.println(Printer.RED + "Invalid input. The start week should be before the end week.");
//                    continue;
//                }
//
//                openActivity.startEndWeeks[0] = start;
//                openActivity.startEndWeeks[1] = end;
//
//                openActivity.parentProject.updateStartEndWeeks();
//
//                break;
//            } catch (Exception e) {
//                System.out.println(Printer.RED + "Please enter valid integers separated by a comma. Give new input." + Printer.RESET);
//                continue;
//            }
//        }
//    }
}
