import junit.framework.TestCase;

public class ProjectsStoryTests extends TestCase {
    private ProjectsBridgeInterface bridge;
    public ProjectsStoryTests(){
        super();
    }
    protected void SetUp() throws Exception {
        super.setUp();
        bridge = Driver.getBridge();
    }

    public boolean login(String username,String password){
        return bridge.login(username,password);
    }

    public boolean addProjectDetails(String nameProject,String desc ,int scopeHours,String fName,String lName,String email,int phone,String organization){
        return bridge.addProjectDetails(nameProject,desc ,scopeHours,fName,lName,email,phone,organization);
    }

    public boolean projectStatusCheck(String code){
        return bridge.projectStatusCheck(code);
    }

    public boolean limitedTime(int scopeHours){
        return bridge.limitedTime(scopeHours);
    }

    public boolean registerProject(int studentID1, int studentID2, int studentID3, int studentID4,
                                   String instructorName){
        return bridge.registerProject(studentID1, studentID2, studentID3, studentID4, instructorName);
    }
    public boolean chooseProject(String projectName){
        return bridge.chooseProject(projectName);
    }
}
