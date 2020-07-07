public class ProxyBridge implements ProjectsBridgeInterface {
    public ProjectsBridgeInterface real;

    public ProxyBridge(){this.real=null;}

    public boolean login(String username, String password){
        if (this.real!=null)
            return real.login(username,password);
        return false;
    }

    public boolean addProjectDetails(String nameProject,String desc ,int scopeHours,String fName,String lName,String email,int phone,String organization){
        if (this.real!=null)
            return real.addProjectDetails(nameProject,desc,scopeHours,fName,lName,email,phone,organization);
        return false;
    }

    public boolean projectStatusCheck(String code){
        if (this.real!=null)
            return this.real.projectStatusCheck(code);
        return false;
    }

    public boolean  limitedTime(int scopeHours){
        if (this.real!=null)
            return this.real.limitedTime(scopeHours);
        return false;
    }

    public boolean registerProject(int studentID1, int studentID2, int studentID3, int studentID4, String instructorName){
        if (this.real!=null)
            return this.real.registerProject(studentID1, studentID2, studentID3, studentID4, instructorName);
        return false;
    }
    public boolean chooseProject(String projectName){
        if (this.real!=null)
            return this.real.chooseProject(projectName);
        return false;
    }
}
