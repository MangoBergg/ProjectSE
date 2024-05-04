package dtu.example.interfaces;

import java.util.List;

import dtu.example.model.Absence;
import dtu.example.model.ConsumedTime;

public interface IEmployee {

    String getEmployeeID();

    List<Absence> getAbsence();

    List<ConsumedTime> getConsumedTimes();
    
    void updateConsumedTime(double hours, IActivity activity) throws Exception;

    void registerAbsence(String reason, int weekStart, int weekEnd) throws Exception;

}