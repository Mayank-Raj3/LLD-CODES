package LLD1_ATM_Design.Naive;

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM();

        int txnId = atm.startTransaction();

        if (atm.readCard("Visa", "4534 3456 5839 5601", 1234)) {
            atm.withdrawAmount(txnId, "4534 3456 5839 5601", 1000);
        } else {
            System.out.println("Authentication failed. Ending transaction.");
        }

        atm.cancelTransaction(txnId); // Optional based on your flow
    }
}
