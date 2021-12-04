package pgdp.collections;

public class StackConnector<T> implements DataStructureConnector<T> {
    private Stack<T> myStack = new LinkedStack<>();

    public StackConnector(Stack<T> myStack) {
        this.myStack = myStack;
    }

    @Override
    public T removeNextElement() {
      if(myStack.isEmpty()) return null;
      else return myStack.pop();
    }

    @Override
    public void addElement(T thing) {
        myStack.push(thing);
    }

    @Override
    public boolean hasNextElement() {
        return !myStack.isEmpty();
    }
}
