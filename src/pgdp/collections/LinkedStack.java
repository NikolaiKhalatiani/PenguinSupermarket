package pgdp.collections;

public class LinkedStack<T> implements Stack<T> {
    private List<T> top;

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public int size() {
        return top.length();
    }

    @Override
    public T pop() {
        if (isEmpty()) return null;
        else {
            T inHand = top.getInfo();
            top.delete();
            return inHand;
        }

    }

    @Override
    public void push(T thing) {
        top.insert(thing);
    }
}
