package pgdp.collections;

public class LinkedQueue<T> implements Queue<T> {
    private List<T> head;

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public int size() {
        if (head != null) return head.length();
       else return 0;
    }

    @Override
    public T dequeue() {
        if(isEmpty())return null;
        else
        {
            T inHand = head.getInfo();
            head = head.getNext();
            return inHand;
        }

    }

    @Override
    public void enqueue(T thing) {
        if (isEmpty()) head = new List<>(thing);
        else {
            List<T> pointer;
            for (pointer = head; pointer.getNext() != null; ) pointer = pointer.getNext();
            pointer.insert(thing);
        }
    }
}
