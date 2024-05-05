package system.program.interfaces;

import java.util.List;

public interface IActivity {

    String getName();

    IProject getParentProject();

    int[] getStartEndWeeks();

    double getBudgetedTime();

    double getConsumedTime();

    List<IEmployee> getAssignedEmployees();

    void setName(String name);

    void setParentProject(IProject project);

    void updateStartEndWeeks(int weekStart, int weekEnd);

    void updateBudgetedTime(double budgetTime) throws Exception;

    void updateConsumedTime(double double1);

    void assignEmployee(IEmployee employee) throws Exception;

    boolean containsAssignedEmployee(IEmployee employee);

}