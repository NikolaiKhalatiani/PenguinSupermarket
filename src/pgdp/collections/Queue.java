package pgdp.collections;

public interface Queue<T> extends DataStructure{
    T enqueue();
    void enqueue(T thing);
}
