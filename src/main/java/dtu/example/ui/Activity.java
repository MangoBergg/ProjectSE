package dtu.example.ui;

import java.util.Objects;

public class Activity {

    private String name;
    private int[] startEndWeeks = new int[2];
    private double budgetTime = 0.0;
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


    public void updateBudgetedTime(double budgetTime) throws Exception {
        if (budgetTime <= 0.0) {
            throw new Exception("Budgeted time must be greater than 0.5 hours");
        }
        if (budgetTime % 0.5 != 0) {
            throw new Exception("Invalid input. Please ensure your number is in increments of 0.5");
        }
            this.budgetTime = budgetTime;
    }


        public double getBudgetTime () {
            return budgetTime;
        }
    }


