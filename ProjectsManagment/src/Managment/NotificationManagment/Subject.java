package Managment.NotificationManagment;

public interface Subject {
    public void register (Observer observer);
    public void unRegister(Observer observer);
    public void notifyAll(ApprovedProjectInfo api);
}
