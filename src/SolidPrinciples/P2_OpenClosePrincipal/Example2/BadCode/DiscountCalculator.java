package SolidPrinciples.P2_OpenClosePrincipal.Example2.BadCode;

enum ProductType {
    ELECTRONICS,
    CLOTHING;
}

public class DiscountCalculator {
    public double calculateDiscount(Product product) {
        if (product.getType() == ProductType.ELECTRONICS) {
            return product.getPrice() * 0.10; // 10% discount
        } else if (product.getType() == ProductType.CLOTHING) {
            return product.getPrice() * 0.20; // 20% discount
        }
        return 0;
    }
}