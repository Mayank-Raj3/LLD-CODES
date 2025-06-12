package StrategyPattern;

public interface RefundCompatibleCreditCard {
    public void doRefund();

    // MAster , amex - > Algo 1 for refund
    // Visa , Rupay - > Algo 2 for refund
    //Leads To code Duplication Moves to Strategy Pattern
}
