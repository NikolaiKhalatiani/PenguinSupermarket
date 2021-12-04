package pgdp.collections;

public class DataStructureLink<T> {
    private DataStructureConnector<T> first;
    private DataStructureConnector<T> second;

    public DataStructureLink(DataStructureConnector<T> first, DataStructureConnector<T> second) {
        this.first = first;
        this.second = second;
    }


    }