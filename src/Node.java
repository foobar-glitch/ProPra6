public class Node<X> {

    private Node<X> next = null;
    private X value = null;

    public Node(X value){this.value = value;}
    public Node<X> next(){return this.next;}
    public X value(){return this.value;}
    public void setNext(Node<X> node){this.next = node;}
}
