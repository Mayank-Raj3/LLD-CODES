package SolidPrinciples.P3_Liskov_Substitution_Principle.Abstraction_Interface;

public class Lenovo extends Product{
    @Override
    double getDiscount() {
        return 100;
    }
    @Override
    public  void termsAndCondition() {
        System.out.println("Lenovo Terms and Condition");
    }
}
