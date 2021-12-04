package pgdp.collections;

public class QueueConnector<T> implements DataStructureConnector<T>{
    private Queue<T> myQueue = new LinkedQueue<>();
    public QueueConnector(Queue<T> myQueue){
        this.myQueue=myQueue;
    }
    @Override
    public T removeNextElement() {
        if(!hasNextElement()) return null;
        else return myQueue.dequeue();
    }

    @Override
    public void addElement(T thing) {
        myQueue.enqueue(thing);
    }

    @Override
    public boolean hasNextElement() {
        return !myQueue.isEmpty();
    }
}
