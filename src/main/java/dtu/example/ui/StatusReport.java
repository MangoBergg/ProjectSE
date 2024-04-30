package dtu.example.ui;

public class StatusReport {

    String report;

    public StatusReport(Project project) {
        this.report = createStatusReport(project);
    }   

     // The following code is partly made with help from chatGPT
     public String createStatusReport(Project project){

        StringBuilder report = new StringBuilder();
        report.append("Status Report:\n");
        report.append("---------------------------------------------------------\n");


        for (Activity activity : project.getActivityList()) {
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

    public String getReport() {
        return report;
    }

}
