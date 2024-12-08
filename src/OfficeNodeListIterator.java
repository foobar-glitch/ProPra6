import java.util.NoSuchElementException;

public class OfficeNodeListIterator {

    private OfficeNode current;

    public OfficeNodeListIterator(OfficeNode start) {
        this.current = start;
    }
    public boolean hasNext() {
        return current != null;
    }

    public Office next() {
        if (!hasNext()) throw new NoSuchElementException();
        Office value = current.value();
        current = current.next();
        return value;
    }
}
