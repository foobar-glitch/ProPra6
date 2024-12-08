import java.util.NoSuchElementException;

/**
 * Simple Iterator implementation
 * @param <X> Type X over which Objects is Iterated
 */
public class NodeListIterator<X> implements IteratorGen<X> {

    private Node<X> current;

    /**
     * New NodeListIterator over X Elements
     * @param start Node of a LinkedList/NodeList OR Null if Iterator over 0 elements
     */
    public NodeListIterator(Node<X> start){this.current = start;}

    /**
     * @return True if this.next() returns an Element
     */
    @Override
    public boolean hasNext() {
        return current != null;
    }

    /**
     * @return Next Element from Iterator
     * @throws NoSuchElementException if no next element exists
     */
    @Override
    public X next() {
        if(!hasNext()) throw new NoSuchElementException();
        X value = current.value();
        current = current.next();
        return value;
    }
}