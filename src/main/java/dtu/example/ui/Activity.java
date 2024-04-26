package dtu.example.ui;

import java.util.Objects;

public class Activity {

    private String name;
    private int[] startEndWeeks = new int[2];
    public  Project parentProject;


    public Activity(String string){
        this.name = string;
    }

    public String getName() {
        return name;
    }

    public void updateStartEndWeeks(int weekStart, int weekEnd) throws Exception {
        if (weekEnd < weekStart) {
            throw new Exception("End week cannot be before start week");
        } else {
            startEndWeeks[0] = weekStart;
            startEndWeeks[1] = weekEnd;
            parentProject.updateStartEndWeeks(weekStart, weekEnd);
        }
    }

    public int[] getStartEndWeeks() {
        return startEndWeeks;
    }


    /*public Activity(String name) throws Exception {
        if (!Objects.equals(name, "")) {
            this.name = name;
        } else {
            throw new Exception("Give name");
        }
    }*/


}
