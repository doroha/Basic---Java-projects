package Managment.NotificationManagment;

public class Sms implements Notification {

    @Override
    public String sendNotification(String pName, String url, String studentId) {
        return "SMS for " + studentId + "We want to notice you dear student that " + pName + "Approved,for more detailes and register get-in to-" + url;}
}

