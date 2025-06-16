/**
 * Node class for use in the Stack class.
 * Represents a single element/node in a linked list, storing a string and a reference to the next node.
 */
public class Node {
    
    String value; // The string value held by this node
    Node next; // Reference to the next node in the list

    /**
     * Constructor to create a new node with a specified string
     * @param s The string to store in this node
     */
    public Node(String s){
        value = s; // Initialize the node's value with the given string
        next = null; // Set the next node reference to null indicating the end of the list at this node
    }
}
