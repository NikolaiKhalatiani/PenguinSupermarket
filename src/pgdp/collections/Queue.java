package pgdp.collections;

public interface Queue<T> extends DataStructure{
    T dequeue();
    void enqueue(T thing);
}
