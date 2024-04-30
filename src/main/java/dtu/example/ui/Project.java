package dtu.example.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Project {
    private String name;
    private int projectID;
    private List<Activity> activityList = new ArrayList<>();
    private int[] startEndWeeks = new int[2];



    public Project(String string, int projectID){
        this.name = string;
        this.projectID = projectID;
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


    // The following code is partly made with help from chatGPT
    public String createStatusReport(){

        StringBuilder report = new StringBuilder();
        report.append("Status Report:\n");
        report.append("---------------------------------------------------------\n");


        for (Activity activity : activityList) {
            double budgetTime = activity.getBudgetTime();
            double totalConsumedTime = activity.getTotalConsumedTime();

            double percentageConsumedTime = (totalConsumedTime / budgetTime) * 100;

            report.append(String.format("Activity: %s\n", activity.getName()));
            report.append(String.format("Budgeted time: %.2f hours\n", budgetTime));
            report.append(String.format("Time consumed: %.2f hours\n", totalConsumedTime));
            report.append(String.format("Percentage of time consumption wrt. budgeted time: %.2f%%\n\n", percentageConsumedTime));
        }
        return report.toString();

    }

}
