package pgdp.collections;

public class Checkout {
    private final Queue<PenguinCustomer> queue;
    private final Queue<FishyProduct> bandBeforeCashier;
    private final Queue<FishyProduct> bandAfterCashier;


    public Checkout() {
        this.queue = new LinkedQueue<>();
        this.bandBeforeCashier = new LinkedQueue<>();
        this.bandAfterCashier = new LinkedQueue<>();
    }

    public Queue<PenguinCustomer> getQueue() {
        return queue;
    }

    public Queue<FishyProduct> getBandBeforeCashier() {
        return bandBeforeCashier;
    }

    public Queue<FishyProduct> getBandAfterCashier() {
        return bandAfterCashier;
    }

    public int queueLength() {
        return queue.size();
    }

    public void serveNextCustomer() {
        if (!queue.isEmpty()) {
            PenguinCustomer pengi = queue.dequeue();
            pengi.placeAllProductsOnBand(bandBeforeCashier);
            int sum = 0;
            for (int check = 0; check <= bandBeforeCashier.size() ; check++) {
                FishyProduct item = bandBeforeCashier.dequeue();
                int price = item.getPrice();
                sum+=price;
                bandAfterCashier.enqueue(item);
            }
            pengi.pay(sum);
            pengi.takeAllProductsFromBand(bandAfterCashier);
        }
    }
}