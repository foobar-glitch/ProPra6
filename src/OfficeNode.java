public class OfficeNode {

    private OfficeNode next = null;
    private final Office value;

    /**
     * Creates new Node with given value
     * @param value value of new Node
     */
    public OfficeNode(Office value){this.value = value;}

    /**
     * @return Next RoomNode or Null if next does not exist
     */
    public OfficeNode next(){return next;}

    /**
     * @return value of this Node
     */
    public Office value(){return value;}

    /**
     * Set next Node of this to node
     */
    public void setNext(OfficeNode node){
        this.next = node;
    }

}
