import java.util.NoSuchElementException;

/**
 * Simple Iterator implementation
 * @param <X> Type X over which Objects is Iterated
 */
public class NodeListIterator<X> implements IteratorGen<X> {

    private Node<X> current;

    public NodeListIterator(Node<X> start){this.current = start;}

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public X next() {
        if(!hasNext()) throw new NoSuchElementException();
        X value = current.value();
        current = current.next();
        return value;
    }
}