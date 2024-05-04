package dtu.example.model;

import dtu.example.interfaces.IAbsence;

public class Absence implements IAbsence {
    
    public String absenceReason;
    public int[] absenceWeeks = new int[2];

    public Absence(String reason, int weekStart, int weekEnd) {
        absenceReason = reason;
        absenceWeeks[0] = weekStart;
        absenceWeeks[1] = weekEnd;
    }
}
