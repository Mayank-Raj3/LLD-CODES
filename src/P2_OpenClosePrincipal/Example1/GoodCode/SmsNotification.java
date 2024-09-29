package P2_OpenClosePrincipal.Example1.GoodCode;

public class SmsNotification implements Notification {
    @Override
    public void send() {
        System.out.println("Sending sms notification");
    }
}
