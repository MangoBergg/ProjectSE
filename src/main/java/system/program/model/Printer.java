package system.program.model;

import java.util.List;

import system.program.interfaces.IActivity;
import system.program.interfaces.IEmployee;
import system.program.interfaces.IPrinter;
import system.program.interfaces.IProject;

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
            contained += IPrinter.GREEN + " Planned: " + IPrinter.RESET + activity.getStartEndWeeks()[0] + " - " + activity.getStartEndWeeks()[1];
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

    public static void displayChoices() {
        System.out.print(IPrinter.RESET +
                        "1 - Add Project. 2 - Assign Project Manager. 3 - Get Status Report \n" +
                        "4 - Create Activity. 5 - Change Start and End Weeks. 6 - Change Budgeted Time \n" + 
                        "7 - Assign Employee to Activity. 8 - Find Free Employee \n" + 
                        "9 - Register Consumed Time. 10 - Register Absence \n" + 
                        "11 - Delete Project \n"
        );
    }
}