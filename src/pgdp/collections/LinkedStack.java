package pgdp.collections;

public class LinkedStack<T> implements Stack<T> {
    private List<T> top;

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public T pop() {
        return null;
    }

    @Override
    public void push(T thing) {
    top = new List<>(thing, top);
    }
}
