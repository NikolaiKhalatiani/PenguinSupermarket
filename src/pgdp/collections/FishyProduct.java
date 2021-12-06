package pgdp.collections;

public class FishyProduct {
    private final String name;
    private final int price;

    public FishyProduct(String name, int price) {
        if (name == null || price <= 0) ExceptionUtil.illegalArgument("This is not Allowed");
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "FishyProduct(" + '"' + getName() + '"' +
                ", " + getPrice() +
                ')';
    }
}
