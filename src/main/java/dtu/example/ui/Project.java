package dtu.example.ui;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private String name;
    private int projectID;
    private Employee projectManager;
    private List<Activity> activityList = new ArrayList<>();
    private int[] startEndWeeks = new int[2];

    public Project(String string, int projectID){
        this.name = string;
        this.projectID = projectID;
    }
    
    public List<Activity> getActivityList() {
        return activityList;
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
    
    public int[] getStartEndWeeks() {
        return startEndWeeks;
    }
    
    public void setProjectManager(Employee newProjectmanager) {
        projectManager = newProjectmanager;
    }

    public boolean containsActivity(String activityName) {
        return activityList.stream().anyMatch(a -> a.getName().equals(activityName));
    }

    public void updateStartEndWeeks(int weekStart, int weekEnd) {
        // Precondition
        assert startEndWeeks[0] == 0 || startEndWeeks[0] > weekStart;
        startEndWeeks[0] = weekStart;

        assert startEndWeeks[1] < weekEnd;
        startEndWeeks[1] = weekEnd;

        // Postcondition
        assert (startEndWeeks[0] == weekStart);
        assert (startEndWeeks[1] == weekEnd);

    }

    public String makeReport() {
        StringBuilder returnString = new StringBuilder();
        returnString.append("Status Report:\n");
        returnString.append("---------------------------------------------------------\n");

        for (Activity activity : getActivityList()) {
            double budgetTime = activity.getBudgetedTime();
            double totalConsumedTime = activity.getConsumedTime();

            double percentageConsumedTime = (totalConsumedTime / budgetTime) * 100;

            returnString.append(String.format("Activity: %s\n", activity.getName()));
            returnString.append(String.format("Budgeted time: %.2f hours\n", budgetTime));
            returnString.append(String.format("Time consumed: %.2f hours\n", totalConsumedTime));
            returnString.append(String.format("Percentage of time consumption wrt. budgeted time: %.2f%%\n\n", percentageConsumedTime));
        }

        return returnString.toString();
    }
}
