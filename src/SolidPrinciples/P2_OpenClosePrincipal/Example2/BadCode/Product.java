package SolidPrinciples.P2_OpenClosePrincipal.Example2.BadCode;

class Product {
    ProductType type;
    double price;
    double getPrice() {
        return price;
    }

    ProductType getType() {
        return type;
    }
}
