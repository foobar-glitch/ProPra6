import java.util.NoSuchElementException;

/**
 * Simple Iterator iver Room objects implementation
 */
class RoomNodeListIterator implements Iterator {

    RoomNode current;

    public RoomNodeListIterator(RoomNode start) {
        this.current = start;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public Room next() {
        if (!hasNext()) throw new NoSuchElementException();
        Room value = current.value;
        current = current.next;
        return value;
    }
}