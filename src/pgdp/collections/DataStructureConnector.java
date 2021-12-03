package pgdp.collections;

public interface DataStructureConnector<T> {
    T removeNextElement();
    void addElement(T thing);
    boolean hasNextElement();

}
