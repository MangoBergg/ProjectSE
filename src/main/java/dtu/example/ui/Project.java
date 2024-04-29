package dtu.example.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Project {
    private String name;
    private int projectID;
    private List<Activity> activityList = new ArrayList<>();
    private int[] startEndWeeks = new int[2];

    private Employee projectLeader;

    //private Project parentProject;

    public Project(String string, int projectID){
        this.name = string;
        this.projectID = projectID;
    }

    public void setProjectLeader(Employee employee) {
        this.projectLeader = employee;
    }

    public Employee getProjectLeader() {
        return projectLeader;
    }

    public String getName() {
        return name;
    }

    public int getProjectID(){
        return projectID;
    }

    public List<Activity> getActivityList(){
        return activityList;
    }
    public void addActivity(Activity activity) {
        activityList.add(activity);
    }

    public boolean containsActivity(String activityName) {
        return activityList.stream().anyMatch(a -> a.getName().equals(activityName));
    }

    public void updateStartEndWeeks(int weekStart, int weekEnd) {

        for (Activity activity : activityList) {
            if (startEndWeeks[0] == 0 || startEndWeeks[0] > weekStart) {
                startEndWeeks[0] = weekStart;
            }

            if (startEndWeeks[1] < weekEnd) {
                startEndWeeks[1] = weekEnd;
            }
        }
    }

    public int[] getStartEndWeeks() {
        return startEndWeeks;
    }
}
