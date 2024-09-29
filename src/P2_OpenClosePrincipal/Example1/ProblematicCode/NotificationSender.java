package P2_OpenClosePrincipal.Example1.ProblematicCode;
import java.util.*;
public class NotificationSender {
    public void sendNotification(List<NotificationType> notificationTypes){
        // This list of notification type consists of notification types that the user has opted now we will call
        // the notification service
        /*
        * this does not follows ocp since we need to modify the whole file to add new things
        * OCP- Open for extension but closed for modification
        * */
        for(NotificationType type: notificationTypes){
            if(type==NotificationType.EMAIL){
                type.sendEmailNotification();
            }else if(type==NotificationType.SMS){
                type.sendSMSNotification();
            }else if(type==NotificationType.WHATSAPP){
                type.sendSMSNotification();
            }
        }
    }
}
