package dtu.example.ui;

import java.util.List;
import java.util.Scanner;

//import collection.Employee;
import dtu.example.ui.Printer;
import dtu.example.ui.Project;
//import collection.ProjectActivity;

public class ProjectSystemHelper {
   
//    public ProjectActivity openActivity(List<ProjectActivity> activities,Scanner inputScanner) {
//        String nameOfActivity;
//        inputScanner.nextLine();
//
//        while (true) {
//            System.out.println(Printer.BLUE + "Provide the name of the activity you want to open (or type 'back' to go back):" + Printer.RESET);
//            nameOfActivity = inputScanner.nextLine();
//
//            if (nameOfActivity.equalsIgnoreCase("back")) {
//                return null; // No project is chosen. Null pointer exception is handled in projectmanagement system at method call.
//            }
//
//            for (ProjectActivity activity : activities) {
//                if (String.valueOf(activity.nameOfActivity).equals(nameOfActivity)) {
//                    return activity;
//                }
//            }
//
//            System.out.println("No activity found with name: " + nameOfActivity + ". Please try again or type 'back' to go back.");
//        }
//    }
//
//    public void displayProjectOverview(Employee user, List<Project> projects) {
//        int i = 1;
//        int j = 1;
//        String contained = "";
//        String notContained = "";
//        for (Project project : projects) {
//            if (project.assignedEmployees.contains(user)) {
//                if (i == 4) {
//                    contained += ("\n");
//                    i = 0;
//                }
//                contained += (Printer.PURPLE + "[" +  project.projectNumber + "] " + Printer.GREEN + project.name + Printer.RESET + "   ");
//                i++;
//            } else {
//                if (j == 4) {
//                    notContained += ("\n");
//                    j = 0;
//                }
//                notContained += (Printer.PURPLE + "[" +  project.projectNumber + "] " + Printer.GREEN + project.name + Printer.RESET + "   ");
//                j++;
//            }
//        }
//
//        if (!contained.isBlank() && !notContained.isBlank()) {
//            System.out.println(Printer.BLUE + "You are assigned to the projects:");
//            Printer.printLine();
//            System.out.print(contained + "\n");
//            System.out.println(Printer.BLUE + "Following projects also exist in the system:");
//            System.out.println(notContained);
//            Printer.printLine();
//        } else if (contained.isBlank() && !notContained.isBlank()) {
//            System.out.println(Printer.BLUE + "Following projects exist in the system:");
//            Printer.printLine();
//            System.out.println(notContained);
//            Printer.printLine();
//        } else if (!contained.isBlank() && notContained.isBlank()) {
//            System.out.println(Printer.BLUE + "You are assigned all the projects in the system:");
//            Printer.printLine();
//            System.out.println(contained);
//            Printer.printLine();
//        } else {
//            System.out.println(Printer.BLUE + "There are no projects in the system");
//        }
//    }
//
//    public void displayActivityOverview(Employee user, Project project) {
//        int i = 1;
//        int j = 1;
//        String contained = "";
//        String notContained = "";
//
//        for (ProjectActivity projectActivity : project.activities) {
//            if (projectActivity.assignedEmployees.contains(user)) {
//                if (i == 4) {
//                    contained += ("\n");
//                    i = 0;
//                }
//                contained += (Printer.PURPLE + "[" +  projectActivity.nameOfActivity + "]\n");
//                i++;
//            } else {
//                if (j == 4) {
//                    notContained += ("\n");
//                    j = 0;
//                }
//                notContained += (Printer.PURPLE + "[" +  projectActivity.nameOfActivity + "]\n");
//                j++;
//            }
//        }
//
//
//        if (!contained.isBlank() && !notContained.isBlank()) {
//            System.out.println(Printer.BLUE + "You are assigned to the following activites in the project " + project.name + ":");
//            System.out.print(contained + "\n");
//            System.out.println(Printer.BLUE + "Following activites also exist in the project:");
//            System.out.println(notContained);
//        } else if (contained.isBlank() && !notContained.isBlank()) {
//            System.out.println(Printer.BLUE + "Following activities exist in the project:");
//            System.out.print(notContained);
//        } else if (contained.isBlank() && notContained.isBlank()) {
//            System.out.println(Printer.BLUE + "There are no activities in the project " + project.name);
//        } else {
//            System.out.println(Printer.BLUE + "You are assigned all the activities in the project " + project.name + ":");
//        }
//    }
//
//    public void displayProjectDetails(Employee user, Project project) {
//        System.out.println(Printer.BLUE + "Project '" + Printer.PURPLE + project.name + Printer.BLUE + "': \n" +
//            Printer.BLUE + "    Scheduled Weeks: " + Printer.PURPLE + "[" + project.startEndWeeks[0] + " - " + project.startEndWeeks[1] + "]\n"
//        );
//
//        if (project.assignedEmployees.isEmpty()) {
//            System.out.println(Printer.BLUE + "There are no assigned employees");
//        } else {
//            System.out.println(Printer.BLUE + "Assigned employees:");
//            int i = 0;
//            for (Employee employee : project.assignedEmployees) {
//                if (i == 5) {
//                    System.out.println();
//                    i = 0;
//                }
//
//                System.out.print("[" + Printer.PURPLE + employee.employeeID + Printer.BLUE + "] ");
//                i++;
//            }
//        }
//    }
//
//    public void displayActivityDetails(Employee user,ProjectActivity openActivity) {
//        System.out.println(Printer.BLUE + "Activity '" + Printer.PURPLE + openActivity.nameOfActivity + Printer.BLUE + "': \n" +
//            Printer.BLUE + "    Scheduled Weeks: " + Printer.PURPLE + "[" + openActivity.startEndWeeks[0] + " - " + openActivity.startEndWeeks[1] + "]\n" +
//            Printer.BLUE + "    Budget time: " + Printer.PURPLE + openActivity.budgetTime
//        );
//
//        if (openActivity.assignedEmployees.isEmpty()) {
//            System.out.println(Printer.BLUE + "There are no assigned employees");
//        } else {
//            System.out.println(Printer.BLUE + "Assigned employees:");
//            int i = 0;
//            for (Employee employee : openActivity.assignedEmployees) {
//                if (i == 5) {
//                    System.out.println();
//                    i = 0;
//                }
//
//                System.out.print("[" + Printer.PURPLE + employee.employeeID + Printer.BLUE + "] ");
//                i++;
//            }
//        }
//    }

}
