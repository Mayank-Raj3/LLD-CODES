package PrototypePattern.ProblemWithCopyConstructor;

public class Child extends Parent{
    private String Property4;
    private String Property5;
    public Child(String property1, String property2, String property3,
                 String property4, String property5) {
        super(property1, property2, property3);
        this.Property4 = property4;
        this.Property5 = property5;
    }

    public Child(Child child) {
        super(child); // this is problematic
        this.Property4 = child.Property4;
        this.Property5 = child.Property5;
    }

    //GetterSetters
}

