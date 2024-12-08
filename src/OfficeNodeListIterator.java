import java.util.NoSuchElementException;

/**
 * Simple Iterator over Office objects implementation
 */
public class OfficeNodeListIterator {

    private OfficeNode current;

    /**
     * New NodeListIterator over Office Elements
     * @param start Node of a LinkedList/NodeList OR Null if Iterator over 0 elements
     */
    public OfficeNodeListIterator(OfficeNode start) {
        this.current = start;
    }

    /**
     * @return True if this.next() exists
     */
    public boolean hasNext() {
        return current.next() != null;
    }

    /**
     * @return Next Element from Iterator
     * @throws NoSuchElementException if no next element exists
     */
    public Office next() {
        if (!hasNext()) throw new NoSuchElementException();
        Office value = current.value();
        current = current.next();
        return value;
    }
}
