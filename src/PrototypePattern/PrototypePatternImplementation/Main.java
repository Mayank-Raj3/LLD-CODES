package PrototypePattern.PrototypePatternImplementation;

public class Main {
    public static void main(String[] args) {
        Email e = new Email("abc@gmail.com","abc@gmail.com","Subject","Body");

        //copying Email
        Email copy = e.clone();
        e.displayEmail();

        //Copying Child class i.e Premium Email

        PremiumEmail p = new PremiumEmail("abc@gmail.com","abc@gmail.com","Subject","Body","cc@gmail","bcc@gmail");
        PremiumEmail copyPremium = p.clone();
        copy.displayEmail();

        /*  Its important that
        *   -> We Introduced Prototype Pattern because we were facing issues with COpy constructor when
        *     Base class have its child.
        *   -> Else It was ok to use Copy constructor
        * */

    }
}


/*
* Why it's important to Make Interface Prototype
*
*
* */