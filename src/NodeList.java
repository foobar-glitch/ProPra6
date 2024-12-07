public class NodeList {
    // Node class representing an element of the LinkedList
    public static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    // Head of the linked list
    private Node head;

    // Constructor
    public NodeList() {
        this.head = null;
    }

    // Method to add a string to the end of the list
    public void add(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode; // If list is empty, make the new node the head
            return;
        }
        Node current = head;
        while (current.next != null) { // Traverse to the last node
            current = current.next;
        }
        current.next = newNode; // Add the new node at the end
    }


    // Method to remove a string (first occurrence) from the list
    public boolean remove(String data) {
        if (head == null) return false; // List is empty

        // If the head is the node to remove
        if (head.data.equals(data)) {
            head = head.next;
            return true;
        }

        // Search for the node to remove
        Node current = head;
        while (current.next != null && !current.next.data.equals(data)) {
            current = current.next;
        }

        // If the node was found, remove it
        if (current.next != null) {
            current.next = current.next.next;
            return true;
        }
        return false; // Node not found
    }

    // Method to check if the list contains a string
    public boolean contains(String data) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(data)) return true;
            current = current.next;
        }
        return false;
    }

    // Method to get the size of the linked list
    public int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
    
    /*
    public void iterateWithFor() {
        for (Node current = head; current != null; current = current.next) {
            System.out.println(current.data);
        }
    }
     */
}
