package system.program.interfaces;

import java.util.List;

import system.program.model.Absence;
import system.program.model.ConsumedTime;

public interface IEmployee {

    String getEmployeeID();

    List<Absence> getAbsence();

    List<ConsumedTime> getConsumedTimes();
    
    void changeConsumedTime(double hours, IActivity activity) throws Exception;
    void updateConsumedTime(double hours, IActivity activity) throws Exception;

    void registerAbsence(String reason, int weekStart, int weekEnd) throws Exception;

}