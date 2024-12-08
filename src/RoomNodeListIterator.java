import java.util.NoSuchElementException;

/**
 * Simple Iterator iver Room objects implementation
 */
public class RoomNodeListIterator{

    private RoomNode current;

    public RoomNodeListIterator(RoomNode start) {
        this.current = start;
    }

    public boolean hasNext() {
        return current != null;
    }

    public Room next() {
        if (!hasNext()) throw new NoSuchElementException();
        Room value = current.value;
        current = current.next;
        return value;
    }
}