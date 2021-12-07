package pgdp.collections;

public class PenguinSupermarket {

    private Checkout[] checkouts;

    public Checkout[] getCheckouts() {
        return checkouts;
    }

    public PenguinSupermarket(int n) {
        if (n <= 0) ExceptionUtil.illegalArgument("This is not Allowed");
        this.checkouts = new Checkout[n];
    }

    public Checkout getCheckoutWithSmallestQueue() {
        int firstLine, secondLine, smallestLine = 0;
        Checkout smallest = new Checkout();
        for (int index = 0; index < checkouts.length - 1; index++) {
            for (int jndex = 1; jndex < checkouts.length; jndex++) {
                firstLine = checkouts[index].queueLength();
                secondLine = checkouts[jndex].queueLength();
                smallestLine = Math.min(firstLine, secondLine);
            }

        }
        for (Checkout checkout : checkouts) {
            if (checkout.queueLength() == smallestLine) smallest = checkout;

        }
        return smallest;
    }

}

