package pgdp.collections;

public class PenguinCustomer {
    private final String name;
    private int money;
    private final Stack<FishyProduct> products = new LinkedStack<>();

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
        return "PenguinCustomer (" + '"' + getName() + '"' +
                ", " + getMoney() +
                ')';
    }

    public void addProductToBasket(FishyProduct things) {
        products.push(things);
    }

    public void placeAllProductsOnBand(Queue<FishyProduct> band) {
        DataStructureConnector<FishyProduct> band1 = new QueueConnector<>(band);
        DataStructureConnector<FishyProduct> products1 = new StackConnector<>(products);
        DataStructureLink<FishyProduct> productsToTape = new DataStructureLink<>(products1, band1);
        productsToTape.moveAllFromAToB();

    }

    public void takeAllProductsFromBand(Queue<FishyProduct> tape) {
        DataStructureConnector<FishyProduct> tape1 = new QueueConnector<>(tape);
        DataStructureConnector<FishyProduct> products1 = new StackConnector<>(products);
        DataStructureLink<FishyProduct> productsToTape = new DataStructureLink<>(tape1, products1);
        productsToTape.moveAllFromAToB();

    }

    public void pay(int check) {
        if (money < check || check < 0) ExceptionUtil.illegalArgument("This is not Allowed");
        money -= check;
    }
    public void goToCheckout(PenguinSupermarket pengi){
        pengi.getCheckoutWithSmallestQueue().getQueue().enqueue(this);
    }
}