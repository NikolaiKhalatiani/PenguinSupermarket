package pgdp.collections;

public class FishyProduct {
    private String name;
    private int price;

    public FishyProduct(final String name, final int price) {
        if (name != null && price > 0) {
            this.name = name;
            this.price = price;
        }
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "FishyProduct(" + '"' + name + '"' +
                ", " + price +
                ')';
    }
}
