package Managment.NotificationManagment;

import acptTests.auxiliary.DBSuggestedProjectInfo;

import java.util.ArrayList;
import java.util.Date;


public class Project implements Subject {
    private ArrayList<Observer> subscribedNotifications;
    private ProjectStatus status;
    private DBSuggestedProjectInfo projectInfo;
    private Date date;

public Project(DBSuggestedProjectInfo info){
    this.projectInfo=info;
    this.date=new Date();
    this.status=ProjectStatus.IN_PROGRESS;
    subscribedNotifications=new ArrayList<>();
}


    @Override
    public void register(Observer observer) {
        if (!subscribedNotifications.contains(observer)) subscribedNotifications.add(observer);
    }

    @Override
    public void unRegister(Observer observer) {
        if (subscribedNotifications.contains(observer)) subscribedNotifications.remove(observer);
    }

    @Override  //when the project is approved we notify all the observers that subscribed for geting mesagge about that.
    public void notifyAll(ApprovedProjectInfo api) {
        if (!subscribedNotifications.isEmpty()) {
            for (Observer student : subscribedNotifications)
                    student.update(this, api);
        }
    }

    public ProjectStatus getStatus() {
        return this.status;
    }

    public void setStatus(ProjectStatus projectStatus) {
        this.status=projectStatus;
    }
}
