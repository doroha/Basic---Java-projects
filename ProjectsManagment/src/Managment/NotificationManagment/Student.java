package Managment.NotificationManagment;

import java.util.ArrayList;
import java.util.HashMap;

public class Student implements Observer {
    String userName;
    String password;
    String studentId;
    private Notification strategy;
    private ArrayList<Subject> desirableProjects;
    private ArrayList<ApprovedProjectInfo> approvedProjects;

    public Student(String userName,String password){
        this.userName=userName;
        this.password=password;
        this.strategy=null;
        desirableProjects=new ArrayList<>();
        approvedProjects=new ArrayList<>();
    }
    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public void update(Project project,ApprovedProjectInfo api) {
        if (project.getStatus().equals(ProjectStatus.APPROVED)) {
            approvedProjects.add(api);
            notify(api.getProjectName(),api.getUrl());
        }
        desirableProjects.remove(api.getProjectName());
    }

    public void notify(String projectName,String url) {
        strategy.sendNotification(projectName,this.studentId,url);
    }

    // register for notification for project
    public void registerNotifications(Project project){
        desirableProjects.add(project);
        project.register(this);
    }

    // unregister for notification for project
    public void unRegisterNotifications(Project project){
        desirableProjects.remove(project);
        project.unRegister(this);
    }

    public Notification getStrategy() {
        return strategy;
    }

    public void setStrategy(Notification strategy) {
        this.strategy = strategy;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}
