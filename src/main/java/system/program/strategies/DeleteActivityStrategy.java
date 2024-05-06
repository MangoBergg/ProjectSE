package system.program.strategies;

import java.util.Iterator;
import java.util.Scanner;

import system.program.interfaces.IActivity;
import system.program.interfaces.IEmployee;
import system.program.model.ConsumedTime;
import system.program.model.ErrorMessageHolder;
import system.program.model.Printer;
import system.program.model.ProjectManagementApp;

public class DeleteActivityStrategy implements UserActionStrategy {
    @Override
    public void execute(Scanner inputScanner, ProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage, IEmployee user) {
        try {
            Printer.clearScreen();
            Printer.displayActivityOverview(projectManagementApp.getActivityRepository().getActivityList());
            System.out.println("Which activity do you want to delete?: ");
            int activityInt = Integer.parseInt(inputScanner.nextLine()) - 1;
            IActivity activity = projectManagementApp.getActivityRepository().getActivityList().get(activityInt);
            activity.getParentProject().getActivityList().remove(activity);

            for (IEmployee employee : projectManagementApp.getEmployeeRepository().getEmployeeList()) {
                Iterator<ConsumedTime> iterator = employee.getConsumedTimes().iterator();
            
                while (iterator.hasNext()) {
                    ConsumedTime consumedTime = iterator.next();
            
                    if (activity.getName().equals(consumedTime.activity.getName())) {
                        iterator.remove();
                    }
                }
            }
             

            projectManagementApp.getActivityRepository().getActivityList().remove(activityInt);
            

        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }
}
