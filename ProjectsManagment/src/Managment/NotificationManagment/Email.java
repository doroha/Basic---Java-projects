package Managment.NotificationManagment;

public class Email implements Notification{

    @Override
    public String sendNotification(String pName, String url, String studentId) {
        return "Email for " + studentId + "We want to notice you dear student that " + pName + "Approved,for more detailes and register get-in to-" + url;}
}
