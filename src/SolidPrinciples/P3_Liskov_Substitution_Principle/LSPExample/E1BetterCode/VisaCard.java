package SolidPrinciples.P3_Liskov_Substitution_Principle.LSPExample.E1BetterCode;
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

//    remove that are not common

}