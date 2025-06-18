package SolidPrinciples.P2_OpenClosePrincipal.Example1.ProblematicCode;

public enum  NotificationType {
    SMS,
    EMAIL,
    WHATSAPP;
    public void sendSMSNotification(){
        System.out.println("Sending SMS Notification");
    }
    public void sendEmailNotification(){
        System.out.println("Sending Email Notification");
    }
    public void sendWhatsAppNotification(){
        System.out.println("Sending WhatsApp Notification");
    }
}
