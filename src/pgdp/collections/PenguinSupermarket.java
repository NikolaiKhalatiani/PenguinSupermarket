package pgdp.collections;

public class PenguinSupermarket {

    private Checkout[] checkouts;

    public Checkout[] getCheckouts() {
        return checkouts;
    }

    public PenguinSupermarket(int n) {
        if (n <= 0) ExceptionUtil.illegalArgument("This is not Allowed");
        this.checkouts = new Checkout[n];
        for (int i = 0; i < n; i++) {
            checkouts[i] = new Checkout();
        }

    }

    public Checkout getCheckoutWithSmallestQueue() {
        int firstLine, secondLine, smallestLine = 0, realSmallest = checkouts[0].queueLength();
        Checkout smallest = new Checkout();
        for (int index = 0; index < checkouts.length - 1; index++) {
            for (int jndex = 1; jndex < checkouts.length; jndex++) {
                firstLine = checkouts[index].queueLength();
                secondLine = checkouts[jndex].queueLength();
                smallestLine = Math.min(firstLine, secondLine);
                if (realSmallest > smallestLine) realSmallest = smallestLine;
            }


        }
        for (Checkout checkout : checkouts) {
            if (checkout.queueLength() == realSmallest) smallest = checkout;

        }
        return smallest;
    }

    public void closeCheckout(int index) {
    }
    public void serveCustomers() {
    }
}
