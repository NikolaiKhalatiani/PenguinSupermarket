package pgdp.collections;

public class LinkedStack<T> implements Stack<T> {
    private List<T> top;

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public int size() {
        if (top != null) return top.length();
        else return 0;
    }

    @Override
    public T pop() {
        if (this.isEmpty()) return null;
        else
        {
            T inHand = top.getInfo();
            top = top.getNext();
            return inHand;
        }
    }

    @Override
    public void push(T thing) {
        top= new List<>(thing, top);
    }
}
