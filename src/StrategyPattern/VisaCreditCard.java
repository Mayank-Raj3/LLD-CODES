package StrategyPattern;

public class VisaCreditCard extends CreditCard implements RefundCompatibleCreditCard{
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
        System.out.println("Visa Card Do Refund -> Algo 2 ");
    }
}
