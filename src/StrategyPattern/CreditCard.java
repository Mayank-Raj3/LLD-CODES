package StrategyPattern;

public abstract class CreditCard {
    private String cardNumber;
    private String expiryDate;
    private int cvv;
    //getters Setters

    // These Are common Features Supported By Credit Card
    public abstract void swipeAndPay();
    public abstract void tapAndPay();
    public abstract void onlinePayment();


/*
    public abstract void upiPayment(); //only implemented by visa and mastercard
    public abstract void doRefund(); // here implemented by visa , mastercard , rupay and amex

    Even if we do Interface segregation , it might be the case that doRefund is using 2 algos
    1st -> implemented by visa and rupay
    2nd algo  -> implemented by amex , mastercard

    So There is a possible Code Duplication , Here we Need to implement Strategy Pattern
  */

    /*
    * 1. Implement Interface Segregation for Uncommon things
    * 2. Use Strategy Pattern if Algo used are different
    * */
}
