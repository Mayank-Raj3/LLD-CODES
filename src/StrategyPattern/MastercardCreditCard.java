package StrategyPattern;

public class MastercardCreditCard extends CreditCard implements RefundCompatibleCreditCard{
    @Override
    public void swipeAndPay(){
        System.out.println("Swipe and Pay");
    }
    @Override
    public void tapAndPay(){
        System.out.println("Tap and Pay");
    }
    @Override
    public void onlinePayment(){
        System.out.println("Online Payment");
    }
    @Override //lsp
    public void doRefund(){
        System.out.println("Master Card Do Refund -> Algo 1 ");
    }
}
