package dtu.example.ui;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private String name;
    private int projectID;
    private Employee projectManager;
    private List<Activity> activityList = new ArrayList<>();

    public Project(String string, int projectID){
        this.name = string;
        this.projectID = projectID;
    }

    public String getName() {
        return name;
    }

    public int getProjectID() {
        return projectID;
    }

    public Employee getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(Employee newProjectmanager) {
        projectManager = newProjectmanager;
    }

    public void addActivity(Activity activity) {
        activityList.add(activity);
    }

    public boolean containsActivity(String activityName) {
        return activityList.stream().anyMatch(a -> a.getName().equals(activityName));
    }

    public void displayActivityOverview() {
        String contained = "";

        for (Activity activity : activityList) {
            contained += (Printer.GREEN + activity.getName() + Printer.RESET + "\n");
        }

        if(!contained.isBlank()) {
            System.out.println(Printer.BLUE + "Following activites exist in the project: " + name);
            Printer.printLine();
            System.out.println(contained);
            Printer.printLine();
        }
        else {
            System.out.println(Printer.BLUE + "There are no activites in the project: " + name);
        }
    }
}
