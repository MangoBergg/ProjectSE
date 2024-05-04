package dtu.example.interfaces;

import java.util.List;

import dtu.example.ui.Activity;

public interface IProject {

    List<Activity> getActivityList();

    String getName();

    int getProjectID();

    IEmployee getProjectManager();

    int[] getStartEndWeeks();

    void setProjectManager(IEmployee newProjectmanager);

    boolean containsActivity(String activityName);

    void updateStartEndWeeks(int weekStart, int weekEnd);

    String makeReport();

}