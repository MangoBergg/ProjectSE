package dtu.example.interfaces;

import java.util.List;

import dtu.example.ui.Absence;

public interface IEmployee {

    String getEmployeeID();

    List<Absence> getAbsence();

    void updateConsumedTime(double hours, IActivity activity) throws Exception;

    void registerAbsence(String reason, int weekStart, int weekEnd) throws Exception;

}