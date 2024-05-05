package system.program.interfaces;

public interface IProjectFactory {

    IProject createProject(String string) throws Exception;

    int generateProjectNumber();

}