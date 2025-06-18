package SolidPrinciples.P3_Liskov_Substitution_Principle.Abstraction_Interface;

public class Macbook extends Product{

    @Override
    double getDiscount() {
        return 10;
    }
    @Override
    public void termsAndCondition(){
        System.out.println("Macbook's Terms Adn Condition");
    }
}
