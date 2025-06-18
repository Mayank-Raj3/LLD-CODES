package StrategyPattern;

public class AmexCreditCard extends CreditCard implements RefundCompatibleCreditCard{

    private RefundStrategy refundStrategy;
    public AmexCreditCard() {
        refundStrategy = new BankRefundStrategy();
        // we can pass it as dependency Injection also means through as argument
    }
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
        refundStrategy.doRefund();
        System.out.println("Amex Card Do Refund -> Algo 1 ");
    }
}
