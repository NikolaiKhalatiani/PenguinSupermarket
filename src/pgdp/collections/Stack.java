package pgdp.collections;

public interface Stack<T> extends DataStructure{
    T pop();
    void push(T thing);
}
