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

    public void closeCheckout(int index) {
        if (index >= checkouts.length || checkouts.length == 0 || checkouts.length == 1 || index < 0)
            ExceptionUtil.illegalArgument("This is not Allowed");
        else {
            Checkout closedCheckout = checkouts[index];
            Checkout[] arrayOfCheckouts = new Checkout[checkouts.length - 1];
            for (int jndex = 0; jndex < checkouts.length; jndex++) {
                if(jndex < index) arrayOfCheckouts[jndex] = checkouts[jndex];
                if (jndex > index) arrayOfCheckouts[jndex - 1] = checkouts[jndex];
            }
            checkouts = arrayOfCheckouts;
            if (closedCheckout.queueLength() == 0) return;
            DataStructureConnector<PenguinCustomer> closedCheckout1 = new QueueConnector<>(closedCheckout.getQueue());
            DataStructureConnector<PenguinCustomer> needThisStackToArrangeThemBackwards = new StackConnector<>(new LinkedStack<>());
            DataStructureLink<PenguinCustomer> goGoGo = new DataStructureLink<>(closedCheckout1, needThisStackToArrangeThemBackwards);
            goGoGo.moveAllFromAToB();
            while (needThisStackToArrangeThemBackwards.hasNextElement()) needThisStackToArrangeThemBackwards.removeNextElement().goToCheckout(this);
        }
    }

    public void serveCustomers() {
        for (Checkout checkout : checkouts) checkout.serveNextCustomer();
    }
}

