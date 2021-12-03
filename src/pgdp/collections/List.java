package pgdp.collections;

public class List<T> {
    public final T info;
    public  List<T> next;

    public List(T x) {
        info = x;
        next = null;
    }

    public List(T x, List<T> l) {
        info = x;
        next = l;
    }

    public void insert(T x) {
        next = new List<>(x, next);
    }

    public void delete() {
        if (next != null)
            next = next.next;
    }

    public int length() {
        int result = 1;
        for (List<T> t = next; t != null; t = t.next)
            result++;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[" + info);
        for (List<T> t = next; t != null; t = t.next)
            result.append(", ").append(t.info);
        return result + "]";
    }
}
