package dtu.example.ui;

public class StatusReport {
    
    private Project project;
    public String report;

    public StatusReport(Project project) {
        this.project = project;
        this.report = toString();
    }

    @Override
    public String toString() {
        StringBuilder returnString = new StringBuilder();
        returnString.append("Status Report:\n");
        returnString.append("---------------------------------------------------------\n");

        for (Activity activity : project.getActivityList()) {
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
