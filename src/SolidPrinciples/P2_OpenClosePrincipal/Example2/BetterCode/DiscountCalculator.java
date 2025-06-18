package SolidPrinciples.P2_OpenClosePrincipal.Example2.BetterCode;

public class DiscountCalculator {
    public double calculateDiscount(Product product) {
        return product.calculateDiscount();
    }
}
