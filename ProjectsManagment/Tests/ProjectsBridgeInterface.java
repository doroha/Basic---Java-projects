public interface ProjectsBridgeInterface {

     boolean login (String username, String password);
     boolean addProjectDetails(String nameProject,String desc ,int scopeHours,String fName,String lName,String email,int phone,String organization);
     boolean projectStatusCheck(String code);
     boolean limitedTime(int scopeHours);
     boolean registerProject(int studentID1, int studentID2, int studentID3, int studentID4, String instructorName);
     boolean chooseProject(String projectName);
}
