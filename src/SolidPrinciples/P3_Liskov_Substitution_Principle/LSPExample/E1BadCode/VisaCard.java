package SolidPrinciples.P3_Liskov_Substitution_Principle.LSPExample.E1BadCode;


public class VisaCard extends CreditCard {
    @Override
    public void tapAndPay() {
        System.out.println("Tap and Pay impl of VISA");
    }

    @Override
    public void onlineTransfer() {
        System.out.println("Online Transfer impl of VISA");
    }

    @Override
    public void swipeAndPay() {
        System.out.println("Swipe and Pay impl of VISA");
    }

    @Override
    public void mandatePayments() {
        System.out.println("Mandate payment impl of VISA");
    }

    @Override
    public void upiPayment() {
//        throw new NoSuchMethodException(); We thow an Exception for this as we dont have option of upi in visa
    }

    @Override
    public void intlPayment() {
        System.out.println("Intl payment impl of VISA");
    }
}