package dtu.example.ui;

public class Absence {
    
    public String absenceReason;
    public int[] absenceWeeks = new int[2];

    public Absence(String reason, int weekStart, int weekEnd) {
        absenceReason = reason;
        absenceWeeks[0] = weekStart;
        absenceWeeks[1] = weekEnd;
    }
}