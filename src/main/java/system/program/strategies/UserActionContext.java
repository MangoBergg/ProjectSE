package system.program.strategies;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import system.program.interfaces.IEmployee;
import system.program.model.ErrorMessageHolder;
import system.program.model.ProjectManagementApp;

public class UserActionContext {
    private final Map<Integer, UserActionStrategy> strategyMap = new HashMap<>();

    public UserActionContext() {
        strategyMap.put(1, new CreateProjectStrategy());
        strategyMap.put(2, new UpdateProjectManagerStrategy());
        strategyMap.put(3, new GenerateStatusReportStrategy());
        strategyMap.put(4, new AddActivityToProjectStrategy());
        strategyMap.put(5, new UpdateActivityWeeksStrategy());
        strategyMap.put(6, new UpdateActivityBudgetedTimeStrategy());
        strategyMap.put(7, new AssignEmployeeToActivityStrategy());
        strategyMap.put(8, new FindFreeEmployeeStrategy());
        strategyMap.put(9, new RegisterTimeForActivityStrategy());
        strategyMap.put(10, new RegisterAbsenceStrategy());
        strategyMap.put(11, new DeleteProjectStrategy());
    }

    public void execute(int choice, Scanner inputScanner, ProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage, IEmployee user) {
        UserActionStrategy strategy = strategyMap.get(choice);
        if (strategy != null) {
            strategy.execute(inputScanner, projectManagementApp, errorMessage, user);
        } else {
            System.out.println("Not a valid choice");
        }
    }
}
