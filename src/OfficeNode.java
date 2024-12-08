public class OfficeNode {

    private OfficeNode next = null;
    private final Office value;

    public OfficeNode(Office value){this.value = value;}

    public OfficeNode next(){return next;}
    public Office value(){return value;}

    public void setNext(OfficeNode node){
        this.next = node;
    }

}
