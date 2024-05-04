package dtu.example.model;

import java.util.List;

import dtu.example.interfaces.IActivity;
import dtu.example.interfaces.IEmployee;
import dtu.example.interfaces.IPrinter;
import dtu.example.interfaces.IProject;

public class Printer implements IPrinter {
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
    }

    public static void printAndWait(int millis, String print) {
        try {
            System.out.println(print);
            Thread.sleep(millis); //Sleep for some time to make the program feel real :)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void printAndWait2(int millis, String print) {
        try {
            System.out.print(print);
            Thread.sleep(millis); //Sleep for some time to make the program feel real :)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void printLine() {
        System.out.println(BLACK + "_______________________________________________________________________" + RESET);
    }

    public static void displayProjectOverview(List<IProject> projectList) {
        String contained = "";
        int i = 0;
        for (IProject project : projectList) {
            i++;
            contained += ("(" + i + ") " + IPrinter.PURPLE + "[" +  project.getProjectID() + "] " + IPrinter.GREEN + project.getName() + IPrinter.RESET);
            contained += ("  (Activities : " + project.getActivityList().size() + ")");
            contained += project.getProjectManager() != null ? "    - Project Manager : " + project.getProjectManager().getEmployeeID() + "\n" : "\n";
        }


        if(!contained.isBlank()) {
            System.out.println(IPrinter.BLUE + "Following projects exist in the system:");
            Printer.printLine();
            System.out.println(contained);
            Printer.printLine();
        }
        else {
            System.out.println(IPrinter.BLUE + "There are no projects in the system");
        }
    }

    public static void displayActivityOverview(List<IActivity> activityList) {
        String contained = "";
        int i = 0;

        for (IActivity activity : activityList) {
            i++;
            contained += ("(" + i + ") " + IPrinter.GREEN + activity.getName() + IPrinter.RESET);
            double progress = activity.getBudgetedTime() == 0 ? 0 : activity.getConsumedTime() / activity.getBudgetedTime() * 100;
            contained += " Progress: " + (int) Math.round(progress) +  "%";
            contained += ("  (" + activity.getParentProject().getName() + ") \n");
        }

        if(!contained.isBlank()) {
            System.out.println(IPrinter.BLUE + "Following activites exist in the system:");
            Printer.printLine();
            System.out.println(contained);
            Printer.printLine();
        }
        else {
            System.out.println(IPrinter.BLUE + "There are no activities in the system");
        }
    }

    public static void displayEmployeeOverview(List<IEmployee> employeeList) {
        String contained = "";
        int i = 0;
        
        for (IEmployee employee : employeeList) {
            i++;
            contained += (i + " " + IPrinter.GREEN + employee.getEmployeeID() + IPrinter.RESET + "\n");
        }

        if(!contained.isBlank()) {
            System.out.println(IPrinter.BLUE + "Following employees exist in the system:");
            Printer.printLine();
            System.out.println(contained);
            Printer.printLine();
        }
        else {
            System.out.println(IPrinter.BLUE + "There are no employees in the system");
        }
    }
}