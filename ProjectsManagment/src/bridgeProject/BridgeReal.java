package bridgeProject;

import Managment.*;
import Managment.NotificationManagment.ApprovedProjectInfo;
import Managment.NotificationManagment.Project;
import Managment.NotificationManagment.ProjectStatus;
import acptTests.auxiliary.DBRegisteredProjectInfo;
import acptTests.auxiliary.DBSuggestedProjectInfo;

public class BridgeReal implements BridgeProject {
    private static DBData dbData;


    public BridgeReal(){
        dbData= new DBData();
    }

    @Override
    public void registerNewTechnicalAdviser(String user, String password) {
        dbData.registerNewTechnicalAdviser(user,password);
    }

    @Override
    public void addNewStudent(String user, String password) {
        dbData.addNewStudent(user,password);
    }

    @Override
    public int addNewProject(String user, String pass, DBSuggestedProjectInfo suggestedProject) {
        Project project=new Project(suggestedProject);
        int projectId=checkAddingProject(user,suggestedProject,pass);
        if (projectId>0) {
            project.setStatus(ProjectStatus.APPROVED);
            String url="http//www."+projectId+".com";
            String publisher=suggestedProject.organization+" "+suggestedProject.firstName+" "+suggestedProject.lastName;
            project.notifyAll(new ApprovedProjectInfo(suggestedProject.projectName,suggestedProject.description,publisher,url));
        } else {
            project.setStatus(ProjectStatus.REJECTED);
            project.notifyAll(new ApprovedProjectInfo(suggestedProject.projectName,null,null,null));
        }
        return projectId;
    }

    @Override
    public int registerToProject(String user, String pass, DBRegisteredProjectInfo registeredProject) {
        return checkRegisterToProject(user,pass,registeredProject);
    }

    public int checkRegisterToProject(String user, String pass, DBRegisteredProjectInfo registeredProject) {
        if (!checkRegisterAndLogin(user,pass)||registeredProject.studentList.size()<2||!dbData.existProject(registeredProject.projectId)||registeredProject.academicAdviser==""||registeredProject.academicAdviser==null)
            return 0;
        return dbData.registerToProject(user,pass,registeredProject);
    }

    private int checkAddingProject(String user, DBSuggestedProjectInfo suggestedProject, String pass) {
        if (!checkRegisterAndLogin(user,pass)||!scopeOfProject(suggestedProject)||checkEmptyFields(suggestedProject)||!differentNames(suggestedProject))
                return 0;
        return dbData.addNewProject(suggestedProject);
    }

    private boolean checkRegisterAndLogin(String user,String pass) {
        if (!dbData.checkRegisterUser(user,pass) || !dbData.checkLoginUser(user,pass))
            return false;
        return true;
    }

    private boolean scopeOfProject(DBSuggestedProjectInfo suggestedProjectInfo){
        return (suggestedProjectInfo.numberOfHours>=200 && suggestedProjectInfo.numberOfHours<=300);
    }

    private boolean checkEmptyFields(DBSuggestedProjectInfo suggestedProject) {
    return (suggestedProject.firstName==""||suggestedProject.firstName==null||suggestedProject.lastName==""||suggestedProject.lastName==null||suggestedProject.email==""||suggestedProject.email==null||suggestedProject.phone==""||suggestedProject.phone==null||suggestedProject.projectName==""||suggestedProject.projectName==null||suggestedProject.description==""||suggestedProject.description==null||suggestedProject.numberOfHours==0);
    }

    private boolean differentNames(DBSuggestedProjectInfo suggestedProject) {
        return dbData.differentNames(suggestedProject);
    }
}
