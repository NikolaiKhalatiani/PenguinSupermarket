package pgdp.collections;

public class DataStructureLink<T> {
    private Queue<T> myQueue = new LinkedQueue<>();
    private Stack<T> myStack = new LinkedStack<>();

    public DataStructureLink( Stack<T> myStack,Queue<T> myQueue) {
        this.myQueue = myQueue;
        this.myStack = myStack;
    }

     public boolean moveNextFromAToB() {
        return false;
    }

    public void moveAllFromAToB() {

    }

}