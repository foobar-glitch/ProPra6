import java.util.NoSuchElementException;

public interface IteratorGen<X> {

    /**
     * @return True if this.next() returns an Element
     */
    boolean hasNext();

    /**
     * @return Next Element from Iterator
     * @throws NoSuchElementException if no next element exists
     */
    X next();

}
