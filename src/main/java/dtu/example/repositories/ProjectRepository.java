package dtu.example.repositories;

import java.util.ArrayList;
import java.util.List;

import dtu.example.interfaces.IProject;

public class ProjectRepository {
    private static ProjectRepository instance;

    private List<IProject> projectList = new ArrayList<>();

    private ProjectRepository(){}
    
    public static ProjectRepository getInstance() {
        if (instance == null) {
            instance = new ProjectRepository();
        }
        return instance;
    }

    public IProject getProjectFromName(String projectToFind) throws Exception {
        for (IProject project : projectList) {
            if (project.getName().equals(projectToFind)) {
                return project;
            }
        }
        throw new Exception("That project doesn't exist in the system");
    }

    public List<IProject> getProjectList() {
        return projectList;
    }

    public void addProject(IProject project) {
        projectList.add(project);
    }

    public boolean containsProject(String projectName) {
        return projectList.stream().anyMatch(p -> p.getName().equals(projectName));
    }

    public void reset() { //Only for testing purposes
        instance = new ProjectRepository();
    }
}
