package system.program.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import system.program.interfaces.IActivity;
import system.program.interfaces.IEmployee;
import system.program.interfaces.IProject;

public class Project implements IProject {
    private String name;
    private int projectID;
    private IEmployee projectManager;
    private List<IActivity> activityList = new ArrayList<>();
    private int[] startEndWeeks = new int[2];

    public Project(String string, int projectID){
        this.name = string;
        this.projectID = projectID;
    }
    
    @Override
    public List<IActivity> getActivityList() {
        return activityList;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getProjectID() {
        return projectID;
    }

    @Override
    public IEmployee getProjectManager() {
        return projectManager;
    }
    
    @Override
    public int[] getStartEndWeeks() {
        return startEndWeeks;
    }
    
    @Override
    public void setProjectManager(IEmployee newProjectmanager) {
        projectManager = newProjectmanager;
    }

    @Override
    public boolean containsActivity(String activityName) {
        return activityList.stream().anyMatch(a -> a.getName().equals(activityName));
    }

    @Override
    public void updateStartEndWeeks(int weekStart, int weekEnd) {
        // Precondition
        assert startEndWeeks[0] == 0 || startEndWeeks[0] > weekStart;

        if (weekStart < startEndWeeks[0]) {
            startEndWeeks[0] = weekStart;
        }

        assert startEndWeeks[1] < weekEnd;
        if (weekEnd > startEndWeeks[1]) {
            startEndWeeks[1] = weekEnd;
        }

        // Postcondition
        assert (startEndWeeks[0] == weekStart);
        assert (startEndWeeks[1] == weekEnd);
    }

    @Override
    public String makeReport() {
        StringBuilder returnString = new StringBuilder();
        returnString.append("Status Report:\n");
        returnString.append("---------------------------------------------------------\n");
        returnString.append("Start and end weeks: " + startEndWeeks[0] + " - " + startEndWeeks[1] + "\n");

        for (IActivity activity : getActivityList()) {
            int[] startEndWeeks = activity.getStartEndWeeks();
            double budgetTime = activity.getBudgetedTime();
            double totalConsumedTime = activity.getConsumedTime();

            double percentageConsumedTime = (totalConsumedTime / budgetTime) * 100;

            returnString.append(String.format("Activity: %s\n", activity.getName()));
            returnString.append(String.format("Start and end weeks: %s\n", Arrays.toString(startEndWeeks)));
            returnString.append(String.format("Budgeted time: %.2f hours\n", budgetTime));
            returnString.append(String.format("Time consumed: %.2f hours\n", totalConsumedTime));
            returnString.append(String.format("Percentage of time consumption wrt. budgeted time: %.2f%%\n\n", percentageConsumedTime));
        }
        return returnString.toString();
    }
}
