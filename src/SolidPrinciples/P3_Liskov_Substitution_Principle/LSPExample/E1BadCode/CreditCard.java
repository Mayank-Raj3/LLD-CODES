package SolidPrinciples.P3_Liskov_Substitution_Principle.LSPExample.E1BadCode;

public abstract class CreditCard {
    private int CardNumber;
    private int cvv;
    private String OwnerName;

    public void setCardNumber(int cardNumber) {
        CardNumber = cardNumber;
    }

    public void setOwnerName(String ownerName) {
        OwnerName = ownerName;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }
    public abstract void tapAndPay();

    public abstract void onlineTransfer();

    public abstract void swipeAndPay();

    public abstract void mandatePayments();

    public abstract void upiPayment(); // not all card support upi paymenet so either we need to thrown an
//    exception or write ifelse for that card but that voiates the ocp and lsp

    public abstract void intlPayment();

    public void displayCreditCardDetails() {
        System.out.println("CC Number: " + this.CardNumber + " , With Owner Name: " + this.OwnerName);
    }
}
