package P3_Liskov_Substitution_Principle.LSPExample.E1BetterCode;

public class RupayCard extends CreditCard implements UpiPaymentCompatibleCreditCard {

    @Override
    public void tapAndPay() {
        System.out.println("Rupay Card Tapped and Payed");
    }
    @Override
    public void onlineTransfer() {
        System.out.println("Rupay Card Online Transfer");
    }

    @Override
    public void swipeAndPay() {
        System.out.println("Rupay Card Swiped and Payed");
    }

    @Override
    public void mandatePayments() {
        System.out.println("Rupay Card Mandate Payments");
    }

    @Override
    public void upiPayment() {}
    //    remove that are not common

}
