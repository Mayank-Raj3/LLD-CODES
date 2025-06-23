package LLD1_ATM_Design.Naive;

import java.util.HashMap;
import java.util.Map;

public class ATM {

    // Simulated database of card numbers and pins
    private Map<String, Integer> cardPinDatabase = new HashMap<>();
    private int atmBalance = 100000;

    // Simulated account balances
    private Map<String, Integer> accountBalance = new HashMap<>();

    public ATM() {
        // Pre-load some dummy card data
        cardPinDatabase.put("4534 3456 5839 5601", 1234);
        accountBalance.put("4534 3456 5839 5601", 5000);

        cardPinDatabase.put("9876543210", 4321);
        accountBalance.put("9876543210", 10000);
    }

    public int startTransaction() {
        int transactionId = generateTransactionId();
        System.out.println("Transaction Started with: " + transactionId);
        return transactionId;
    }

    public boolean cancelTransaction(int transactionId) {
        System.out.println("Transaction Canceled with: " + transactionId);
        return true;
    }

    public boolean readCard(String cardType, String cardNumber, int pin) {
        System.out.println("Reading Card Type: " + cardType + " Card Number: " + cardNumber);
        boolean isCardValid = validateCard(cardNumber, pin);
        if (isCardValid) {
            System.out.println("Card Successfully Validated");
            return true;
        } else {
            System.out.println("Card Validation Failed, Invalid Card Number or PIN");
            return false;
        }
    }

    public boolean withdrawAmount(int transactionId, String cardNumber, int amount) {
        System.out.println("Attempting Withdrawal for Transaction ID: " + transactionId + " Card Number: " + cardNumber);
        boolean canWithdraw = validWithdrawalAmount(cardNumber, amount);
        if (canWithdraw) {
            int newBalance = accountBalance.get(cardNumber) - amount;
            accountBalance.put(cardNumber, newBalance);
            System.out.println("Withdrawal Successful. Remaining Balance: ₹" + newBalance);
            return true;
        } else {
            System.out.println("Withdrawal Failed. Insufficient Funds or Invalid Amount.");
            return false;
        }
    }

    private boolean validateCard(String cardNumber, int pin) {
        return cardPinDatabase.containsKey(cardNumber) && cardPinDatabase.get(cardNumber) == pin;
    }

    private boolean validWithdrawalAmount(String cardNumber, int amount) {
        if (!accountBalance.containsKey(cardNumber)) {
            return false;
        }
        int balance = accountBalance.get(cardNumber);
        return (amount > 0 && balance >= amount && amount <=atmBalance);
    }

    private int generateTransactionId() {
        return (int) (Math.random() * 10000);
    }
}
