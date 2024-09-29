package P3_Liskov_Substitution_Principle.Abstraction_Interface;

public abstract class Product {
    abstract double getDiscount();
    public void termsAndCondition() {
        System.out.println("Products Terms and Condition");
    }
}
