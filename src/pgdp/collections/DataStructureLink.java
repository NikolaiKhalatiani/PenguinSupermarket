package pgdp.collections;

public class DataStructureLink<T> {
    private Queue<T> myQueue = new LinkedQueue<>();
    private Stack<T>myStack= new LinkedStack<>();
    public DataStructureLink(Queue<T> myQueue,Stack<T> myStack){
        this.myQueue=myQueue;
        this.myStack=myStack;
    }

    boolean moveNextFromAToB() {
        return false;
    }

    void moveAllFromAToB() {

    }}

 /*   public Stack<T> getMyStack() {
        return myStack;
    }

    public Queue<T> getMyQueue() {
        return myQueue;
    }
}*/
