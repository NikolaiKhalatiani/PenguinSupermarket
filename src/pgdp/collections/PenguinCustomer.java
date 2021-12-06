package pgdp.collections;

public class PenguinCustomer {
    private final String name;
    private int money;
    private Stack<FishyProduct> products;

    public PenguinCustomer(String name, int money) {
        if (name == null || money < 0) ExceptionUtil.illegalArgument("This is not Allowed");
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public Stack<FishyProduct> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Fishy Product(" + '"' + getName() + '"' +
                ", " + getMoney() +
                ')';
    }

    public void addProductToBasket(FishyProduct things) {
        products.push(things);
    }

    public void placeAllProductsOnBand(Queue<FishyProduct> tape) {
        QueueConnector<FishyProduct> tape1 = new QueueConnector<>(tape);
        StackConnector<FishyProduct> products1 = new StackConnector<>(products);
        DataStructureLink<FishyProduct> productsToTape = new DataStructureLink<>(products1, tape1);
        productsToTape.moveAllFromAToB();

    }

    public void takeAllProductsFromBand(Queue<FishyProduct> tape) {
        QueueConnector<FishyProduct> tape1 = new QueueConnector<>(tape);
        StackConnector<FishyProduct> products1 = new StackConnector<>(products);
        DataStructureLink<FishyProduct> productsToTape = new DataStructureLink<>(tape1, products1);
        productsToTape.moveAllFromAToB();

    }

    public void pay(int check) {
        if (Math.abs(money - check) >= 0) money = -check;
    }
}