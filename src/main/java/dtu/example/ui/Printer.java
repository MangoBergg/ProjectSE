package dtu.example.ui;

import java.util.List;

public class Printer {
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

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


    public static void displayProjectOverview(List<Project> projectList) {
        String contained = "";
        int i = 0;
        for (Project project : projectList) {
            i++;
            contained += ("(" + i + ") " + Printer.PURPLE + "[" +  project.getProjectID() + "] " + Printer.GREEN + project.getName() + Printer.RESET);
            contained += ("  (Activities : " + project.getActivityList().size() + ")");
            contained += project.getProjectManager() != null ? "    - Project Manager : " + project.getProjectManager().getEmployeeID() + "\n" : "\n";
        }


        if(!contained.isBlank()) {
            System.out.println(Printer.BLUE + "Following projects exist in the system:");
            Printer.printLine();
            System.out.println(contained);
            Printer.printLine();
        }
        else {
            System.out.println(Printer.BLUE + "There are no projects in the system");
        }
    }

    public static void displayActivityOverview(List<Activity> activityList) {
        String contained = "";
        int i = 0;
        for (Activity activity : activityList) {
            i++;
            contained += (i + Printer.GREEN + activity.getName() + Printer.RESET);
            contained += ("  (" + activity.getParentProject().getName() + ")" + "\n");
        }

        if(!contained.isBlank()) {
            System.out.println(Printer.BLUE + "Following activites exist in the system:");
            Printer.printLine();
            System.out.println(contained);
            Printer.printLine();
        }
        else {
            System.out.println(Printer.BLUE + "There are no activities in the system");
        }
    }

    public static void displayEmployeeOverview(List<Employee> employeeList) {
        String contained = "";

        for (Employee employee : employeeList) {
            contained += (Printer.GREEN + employee.getEmployeeID() + Printer.RESET + "\n");
        }

        if(!contained.isBlank()) {
            System.out.println(Printer.BLUE + "Following employees exist in the system:");
            Printer.printLine();
            System.out.println(contained);
            Printer.printLine();
        }
        else {
            System.out.println(Printer.BLUE + "There are no employees in the system");
        }
    }
}