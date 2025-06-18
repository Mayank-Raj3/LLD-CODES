package PrototypePattern.ProblemWithCopyConstructor;

public class Main {
    public static void main(String[] args) {
        /*
        * Now we have Parent And child class
        *
        * 1. We need to create copy Of Parent
        * 2. Copy Of child
        * */

        Parent p = new Parent("p1","p2","p3");

        Parent copyOfparent = new Parent(p);

        Parent ch = new Child("p1","p2","p3","p4","p5");
//        Child childCopy = new Child((Child) ch);  works fine
//        Parent childCopy = new Child(ch); we should cast it
//        Parent childCopy = new Child((Child)ch);
//
//        Child childCopy = new Parent(ch); Child Cant call parent constructor as its lo in level



        //violating ocp here
        Parent chCopy;
        if (ch instanceof Child) {
            chCopy = new Child((Child) ch);  // ✅ Safe cast
        } else {
            chCopy = new Parent(ch);         // fallback for pure Parent
        }

    }
}
//check
