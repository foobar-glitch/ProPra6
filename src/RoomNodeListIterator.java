import java.util.NoSuchElementException;

/**
 * Simple Iterator over Room objects implementation
 */
public class RoomNodeListIterator{

    private RoomNode current;

    /**
     * New NodeListIterator over Room Elements
     * @param start Node of a LinkedList/NodeList OR Null if Iterator over 0 elements
     */
    public RoomNodeListIterator(RoomNode start) {
        this.current = start;
    }

    /**
     * @return True if this.next() exists
     */
    public boolean hasNext() {
        return current != null;
    }

    /**
     * @return Next Element from Iterator
     * @throws NoSuchElementException if no next element exists
     */
    public Room next() {
        if (!hasNext()) throw new NoSuchElementException();
        Room value = current.value();
        current = current.next();
        return value;
    }
}