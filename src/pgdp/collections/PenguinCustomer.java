package pgdp.collections;

public class PenguinCustomer {
    private String name;
    private int initialMoney;
    private Stack<FishyProduct> basket;

    public PenguinCustomer(final String name, final int initialMoney) {
        if(name!=null&&initialMoney>=0){
            this.name=name;
            this.initialMoney= initialMoney;
        }
    }

    public String getName() {
        return name;
    }

    public int getInitialMoney() {
        return initialMoney;
    }

    public Stack<FishyProduct> getProducts() {
        return basket;
    }

    @Override
    public String toString() {
        return "Fishy Product(" + '"' + name + '"' +
                ", " + initialMoney +
                ')';
    }
    public void addProductToBasket(FishyProduct things){
        basket.push(things);
    }
    public void placeAllProductsOnBand(Queue<FishyProduct> tape){

    }
    public void takeAllProductsFromBand(Queue<FishyProduct> tape){

    }
    public void pay(int check){
        
    }
}
