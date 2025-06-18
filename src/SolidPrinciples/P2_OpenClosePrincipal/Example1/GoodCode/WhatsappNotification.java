package SolidPrinciples.P2_OpenClosePrincipal.Example1.GoodCode;

public class WhatsappNotification implements Notification {
   @Override
    public void send() {
        System.out.println("This is the Whatsapp Notification");
    }
}