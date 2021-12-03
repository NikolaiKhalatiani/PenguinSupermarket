package pgdp.collections;

public class LinkedQueue<T> implements Queue<T>{
    private List<T> head;

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public T dequeue() {
        return null;
    }

    @Override
    public void enqueue(T thing) {

    }
}
