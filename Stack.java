import java.util.NoSuchElementException;

/**
 * Stack class represents a last-in-first-out stack of strings
 */
public class Stack {
    
    Node head;

    /**
     * Constructor to initialize the Stack with no elements
     */
    public Stack(){
        head = null; // Initialize head as null to indicate an empty stack
    }

    /**
     * Pushes a string onto the top of the stack
     * @param s the string to be pushed onto the stack
     */
    public void push(String s){
        if (s == null){
            System.out.println("Input was null. Value not added to the stack");
            return; // Early return if the input string is null
        }
        Node newNode = new Node(s); // Create a new node with the string

        //if stack is empty
        if (head == null){
            head = newNode; //set head as the new node created with the input value
        }
        else{
            newNode.next = head; // Set new node's next to head
            head = newNode; // Update head to new node
        }
    }

    /**
     * Pops the top string from the stack and returns it
     * @return the string at the top of the stack, or null if the stack is empty
     */
    public String pop(){
        if (head == null) {
            System.out.println("Error. Stack is already empty");
            return null; // Return null if stack is empty
        }

        Node curr = head; // Current top node
        Node next = head.next; // Keep track of next node 
        head = next; // Set head as next node
        String str = curr.value; // Set the value to return
        curr = null; // Delete the popped node by setting it to null
        return str; // Return the value of the node removed from the top
    }

    /**
     * Retrieves but does not remove the top string of the stack
     * @return the string at the top of the stack or "Stack is empty" if the stack is empty
     */
    public String peek(){
        if (head == null){
            return "Stack is empty"; // Return message if stack is empty
        }
        return head.value; // Return the top element of the stack
    }

    /**
     * Checks if the stack is empty
     * @return true if the stack is empty, otherwise false
     */
    public boolean isEmpty(){
        
        if (head == null){
            return true; // Return true if head is null
        }
        return false; // Return false if stack is not null
    }

    /**
     * Returns the number of elements in the stack
     * @return the count of elements in the stack
     */
    public int length(){
        Node curr = head;
        int count = 0;
        while(curr != null){
            count++; // Increment count for each node in the stack
            curr = curr.next; // Move to next node

        }
        return count;
    }

    /**
     * Prints all the elements in the stack from top to bottom.
     */
    public void dump(){
        if (head == null){
            System.out.println("Stack is empty"); // Print message if stack is empty
            return;
        }
        Node curr = head;
        while(curr != null){
            System.out.print(curr.value + "->"); // Print each node's value followed by '->'
            curr = curr.next;
        }
        System.out.println(); // Newline for formatting
    }
}
