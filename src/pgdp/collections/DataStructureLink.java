package pgdp.collections;

public class DataStructureLink<T> {
    private Queue<T> myQueue = new LinkedQueue<>();
    private Stack<T> myStack = new LinkedStack<>();

    public DataStructureLink(Queue<T> myQueue, Stack<T> myStack) {
        this.myQueue = myQueue;
        this.myStack = myStack;
    }

     public boolean moveNextFromAToB() {
        if(!myQueue.isEmpty())
        {
            T thing = myQueue.dequeue();
            myStack.push(thing);
            return true;
        }
       else return false;
    }

    public void moveAllFromAToB() {

    }

}