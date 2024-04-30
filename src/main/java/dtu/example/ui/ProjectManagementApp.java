package dtu.example.ui;

import java.sql.SQLOutput;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

public class ProjectManagementApp {

    public List<Project> projectList;
    public List<Activity> activityList;
    public List<Employee> employeeList;

    private Employee user;
    private boolean isLoggedIn = true;
    private boolean cancelProgram = false;
    private Scanner inputScanner;
    private Calendar calendar;
    private int serialNumber = 1;

    public ProjectManagementApp() {
        projectList = new ArrayList<>();
        inputScanner = new Scanner(System.in);
        calendar = Calendar.getInstance();

    }

    public void launch(Employee user){
        this.user = user;

        while (!cancelProgram) {
            Printer.clearScreen();

        }
    }


    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void login() {
        isLoggedIn = isLoggedIn;
    }




    public void addProject(Project project) {
        projectList.add(project);
    }

    // The following code is reused from Hubert's video
    public boolean containsProject(String projectName) {
        return projectList.stream().anyMatch(p -> p.getName().equals(projectName));
    }

    public boolean containsEmployee(String string) {
        return employeeList.stream().anyMatch(e -> e.getEmployeeID().equals(string));

    }

    public Activity createActivity(String string, Project project) throws Exception {
        if (project.containsActivity(string)){
            throw new Exception("An activity named ’Activity’ already exists in this project");
        }

        Activity activity = new Activity(string, project);
        project.addActivity(activity);
        activity.parentProject = project;
        return activity;
    }


    // The following code about the project is reused from Hubert's video
    public Project createProject(String string) throws Exception {
        if (containsProject(string)){
            throw new Exception("Project with that name already exists");
        }
        if (string.isEmpty()) {
            throw new Exception("Give name");
        }
        Project project = new Project(string, generateProjectNumber());
        addProject(project);
        return project;
    }

    public Project getProject(String title) throws Exception {
        
        if (projectList != null) {
            for (Project project : projectList) {
                if (project.getName().equals(title)) {
                    return project;
                }
            }
        }

        throw new Exception("No project exists with that name");
    }

    public Activity getActivity(String activityName) throws Exception{
        
        if (activityList != null) {
            for (Activity activity : activityList) {
                if (activity.getName().equals(activityName)) {
                    return activity;
                }
            }
        }

        throw new Exception("No activity exists with that name");
    }

    public Employee getEmployee(String employeeID) throws Exception{
        
        if (employeeList != null) {
            for (Employee employee : employeeList) {
                if (employee.getEmployeeID().equals(employeeID)) {
                    return employee;
                }
            }
        }

        throw new Exception("No employee exists with that name");
    }

    public int generateProjectNumber() {
        //If serialNumber = 1 and year is 2024 then this method returns 24001.
        int lastTwoYearDigits = calendar.get(Calendar.YEAR) % 100;
        String formatYear = String.format("%02d", lastTwoYearDigits);
        String formatSerial = String.format("%03d", serialNumber);
        serialNumber++;
        return Integer.parseInt(formatYear + formatSerial);
    }
}
