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
        int temp = 0;

        int realSmallest = checkouts[0].queueLength();
        Checkout smallest = new Checkout();
        for (int i = 0; i < checkouts.length; i++) {
            for (int j = i + 1; j < checkouts.length; j++) {

                if (checkouts[i].queueLength() > checkouts[j].queueLength()) {
                    temp = checkouts[i].queueLength();
                    checkouts[i] = checkouts[j];
                }
                for (Checkout checkout : checkouts) {
                    if (checkout.queueLength() == temp) smallest = checkout;

                }
            }
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
                if (jndex > index) arrayOfCheckouts[jndex - 1] = checkouts[jndex];
                if (jndex < index) arrayOfCheckouts[jndex] = checkouts[jndex];
            }
            checkouts = arrayOfCheckouts;
            if (closedCheckout.queueLength() != 0) {

                DataStructureConnector<PenguinCustomer> closedCheckout1 = new QueueConnector<>(closedCheckout.getQueue());
                DataStructureConnector<PenguinCustomer> needThisStackToArrangeThemBackwards = new StackConnector<>(new LinkedStack<>());
                DataStructureLink<PenguinCustomer> goGoGo = new DataStructureLink<>(closedCheckout1, needThisStackToArrangeThemBackwards);
                goGoGo.moveAllFromAToB();
                while (needThisStackToArrangeThemBackwards.hasNextElement())
                    needThisStackToArrangeThemBackwards.removeNextElement().goToCheckout(this);
            }
        }
    }

    public void serveCustomers() {
        for (Checkout checkout : checkouts) checkout.serveNextCustomer();
    }
}
