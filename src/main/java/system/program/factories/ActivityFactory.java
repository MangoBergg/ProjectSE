package system.program.factories;

import system.program.interfaces.IActivity;
import system.program.interfaces.IActivityFactory;
import system.program.interfaces.IProject;
import system.program.model.Activity;
import system.program.repositories.ActivityRepository;

public class ActivityFactory implements IActivityFactory {
    ActivityRepository activityRepository;

    public ActivityFactory() {
        activityRepository = ActivityRepository.getInstance();
    }

    @Override
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
