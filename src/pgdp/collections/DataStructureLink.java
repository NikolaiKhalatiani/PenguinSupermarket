package pgdp.collections;

public class DataStructureLink<T> {
    private Queue<T> myQueue = new LinkedQueue<>();
    private Stack<T> myStack = new LinkedStack<>();

    public DataStructureLink(Queue<T> myQueue, Stack<T> myStack) {
        this.myQueue = myQueue;
        this.myStack = myStack;
    }

     public boolean moveNextFromAToB() {
        if(!myStack.isEmpty())
        {
            myStack.pop();
            myQueue.enqueue(myStack.pop());
            return true;
        }
       else return false;
    }

    public void moveAllFromAToB() {

    }

}