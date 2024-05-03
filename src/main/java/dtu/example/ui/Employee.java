package dtu.example.ui;

import java.util.List;

public interface Employee {
    String getEmployeeID();
    List<Absence> getAbsence();
    void updateConsumedTime(double hours, Activity activity) throws Exception;
    void registerAbsence(String reason, int weekStart, int weekEnd) throws Exception;
}
