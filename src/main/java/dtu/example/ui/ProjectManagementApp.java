package dtu.example.ui;

import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;

public class ProjectManagementApp {

    public List<Project> projectList;
    public List<Activity> activityList;
    public List<Employee> employeeList;
    private Calendar calendar;
    private int serialNumber = 1;

    public ProjectManagementApp() {
        projectList = new ArrayList<>();
        activityList = new ArrayList<>();
        employeeList = new ArrayList<>();
        calendar = Calendar.getInstance();
    }

    public int generateProjectNumber() {
        //If serialNumber = 1 and year is 2024 then this method returns 24001.
        int lastTwoYearDigits = calendar.get(Calendar.YEAR) % 100;
        String formatYear = String.format("%02d", lastTwoYearDigits);
        String formatSerial = String.format("%03d", serialNumber);
        serialNumber++;
        return Integer.parseInt(formatYear + formatSerial);
    }

    public void displayProjectOverview() {
        String contained = "";

        for (Project project : projectList) {
            contained += (Printer.PURPLE + "[" +  project.getProjectID() + "] " + Printer.GREEN + project.getName() + Printer.RESET + "\n");
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

    public Project createProject(String string) throws Exception {
        if (containsProject(string)){
            throw new Exception("Project with that name already exists");
        }
        if (string.isEmpty()) {
            throw new Exception("Give name");
        }
        Project project = new Project(string, generateProjectNumber());
        projectList.add(project);
        return project;
    }

    public boolean containsProject(String projectName) {
        return projectList.stream().anyMatch(p -> p.getName().equals(projectName));
    }

    public Project getProjectFromName(String projectToFind) throws Exception {
        for (Project project : projectList) {
            if (project.getName().equals(projectToFind)) {
                return project;
            }
        }

        throw new Exception("That project doesn't exist in the system");
    }

    public Activity getActivityFromName(String activityToFind) throws Exception {
        for (Activity activity : activityList) {
            if (activity.getName().equals(activityToFind)) {
                return activity;
            }
        }

        throw new Exception("That activity doesn't exist in the system");
    }

    public Employee getEmployeeFromName(String employeeToFind) throws Exception {
        for (Employee employee : employeeList) {
            if (employee.getEmployeeID().equals(employeeToFind)) {
                return employee;
            }
        }

        throw new Exception("That employee doesn't exist in the system");
    }


    public Activity createActivity(String string, Project project) throws Exception {
        if (project.containsActivity(string)){
            throw new Exception("An activity named ’Activity’ already exists in this project");
        }
        if (string.isEmpty()) {
            throw new Exception("Give name for the activity");
        }

        Activity activity = new Activity(string, project);
        activityList.add(activity);
        project.addActivity(activity);
        activity.setParentProject(project);
        return activity;
    }


    public void displayEmployeeOverview() {
        String contained = "";

        for (Employee employee : employeeList) {
            contained += ("\n");
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
