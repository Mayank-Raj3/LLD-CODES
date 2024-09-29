package P2_OpenClosePrincipal.Example2.BetterCode;

class Electronics implements Product {
    private double price;

    public Electronics(double price) {
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public double calculateDiscount() {
        return price * 0.10; // 10% discount for electronics
    }
}