package SolidPrinciples.P3_Liskov_Substitution_Principle.Abstraction_Interface;

interface AA {
    default void doSome() {
        System.out.println("A");
    }
}

interface BB {
    default void doSome() {
        System.out.println("B");
    }
}

class CC implements AA, BB {
    @Override
    public void doSome() {
        BB.super.doSome();  // Call the method from interface BB
    }
}

public class SolutionToDiamond {
    public static void main(String[] args) {
        CC cc = new CC();
        cc.doSome();  // This will print "B"
    }
}
