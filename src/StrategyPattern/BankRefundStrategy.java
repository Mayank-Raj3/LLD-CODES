package StrategyPattern;

public class BankRefundStrategy implements RefundStrategy {
    @Override
    public void doRefund(){
        System.out.println("Refund Initiated on users bank account");
    }

}
