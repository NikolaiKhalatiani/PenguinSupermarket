package pgdp.collections;

public class PenguinSupermarket {

    private final Checkout[] checkouts;

    public Checkout[] getCheckouts() {
        return checkouts;
    }

    public PenguinSupermarket(int n) {
        if (n <= 0) ExceptionUtil.illegalArgument("This is not Allowed");
        this.checkouts = new Checkout[n];
    }

    public PenguinSupermarket getCheckoutWithSmallestQueue() {
        int firstLine, secondLine, smallestLine = 0;
        for (int index = 0; index < checkouts.length - 1; index++) {
            for (int jindex = 1; jindex < checkouts.length; jindex++) {
                firstLine = checkouts[index].queueLength();
                secondLine = checkouts[jindex].queueLength();
                smallestLine = Math.min(firstLine, secondLine);
            }
        }
        return new PenguinSupermarket(smallestLine);
    }

}

