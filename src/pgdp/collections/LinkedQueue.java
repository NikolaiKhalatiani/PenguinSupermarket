package pgdp.collections;

public class LinkedQueue<T> implements Queue<T>{
    private List<T> head;

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public int size() {
        return head.length();
    }

    @Override
    public T dequeue() {
        return null;
    }

    @Override
    public void enqueue(T thing) {

    }
}
