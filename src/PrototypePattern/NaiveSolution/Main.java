package PrototypePattern.NaiveSolution;

public class Main {
    public static void main(String[] args) {
        Email e = new Email("abc@gmail.com","abc@gmail.com","Subject","Body");

        // Method 1 :
        //Violating DRY principle as we keep on repeating the classes,
        // OCP :- if Modification happens in email we have to change here also
        // SRP

        Email copy1 = new Email();
        copy1.setSenderEmail("abc@gmail.com");
        copy1.setReceiverEmail("abc@gmail.com");
        copy1.setSubject("Subject");
        copy1.setBody("Body");
        copy1.displayEmail();


        //Method 2 : Copy using Copy Constructor
        //Better than method 1 as Constructor call is less expensive .
        /**
         * Problems
         * Violating OCP , When it have a child class and we need to create
         * copy of child class
         * then we have to write copy Constructor for class Child ;
         * and If need to check "which copy Constructor" to call
         * which violate OCP
         * **/

        Email copy = new Email(e);
        copy.displayEmail();


    }
}
