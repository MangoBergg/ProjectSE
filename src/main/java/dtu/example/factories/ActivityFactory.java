package dtu.example.factories;

import dtu.example.interfaces.IActivity;
import dtu.example.interfaces.IProject;
import dtu.example.model.Activity;
import dtu.example.repositories.ActivityRepository;

public class ActivityFactory {
    ActivityRepository activityRepository;

    public ActivityFactory() {
        activityRepository = ActivityRepository.getInstance();
    }

    public IActivity createActivity(String string, IProject project) {
        //Pre-conditions
        assert(!string.isEmpty()) : "Name cannot be empty";
        assert(!project.containsActivity(string)) : "The activity already exists in this project";

        IActivity activity = new Activity(string, project);
        activityRepository.addActivity(activity);
        project.getActivityList().add(activity);
        activity.setParentProject(project);

        //Post-conditions
        assert(project.getActivityList().contains(activity)) : "The activity does not exist in activityList, which means it is not created";

        return activity;
    }
}
