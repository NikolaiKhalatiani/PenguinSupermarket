package pgdp.collections;

public class QueueConnector<T> implements DataStructureConnector<T>{
    @Override
    public T removeNextElement() {
        return null;
    }

    @Override
    public void addElement(T thing) {

    }

    @Override
    public boolean hasNextElement() {
        return false;
    }
}
