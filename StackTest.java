import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the Stack class to ensure all stack operations perform as expected
 */
public class StackTest {
    private final PrintStream standardOut = System.out; // To store the original System.out
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream(); // For capturing output

    /**
     * Sets up the environment before each test by capturing the standard output stream
     */
    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor)); // Capture System.out
    }

    /**
     * Restores the standard output stream after each test
     */
    @AfterEach
    public void tearDown() {
        System.setOut(standardOut); // Restore System.out
    }

    /**
     * Tests that a single element is correctly pushed onto an empty stack
     */
    @Test
    @DisplayName("Test push(), empty stack, dependant on dump()")
    public void pushTestDumpEmpty(){
        // Assign
        Stack stack = new Stack(); // Create an empty stack
        stack.push("A"); // Push 'A' onto the stack
        // Act
        stack.dump(); // Dump the stack contents to output
        String actual = outputStreamCaptor.toString().trim(); // Capture the output
        // Assert
        Assertions.assertEquals(actual, "A->"); // Check if the output matches expected
    }
    
    /**
     * Tests that elements are correctly pushed onto a non-empty stack and dumped in order
     */
    @Test
    @DisplayName("Test push(), not empty stack, dependant on dump()")
    public void pushTestDumpNotEmpty(){
        // Assign
        Stack stack = new Stack();
        stack.push("A"); // Push 'A' onto the stack
        stack.push("B"); // Push 'B' onto the stack
        // Act
        stack.dump(); // Dump the stack contents to output
        String actual = outputStreamCaptor.toString().trim(); // Capture the output
        // Assert
        Assertions.assertEquals(actual, "B->A->"); // Check if the output matches expected
    }

    /**
     * Tests that an element with a null value cannot be pushed onto an empty stack
     */
    @Test
    @DisplayName("Test push() with null, empty stack, dependant on dump()")
    public void pushTestNullDumpEmpty(){
        // Assign
        Stack stack = new Stack();
        String s = null; // Create a string with a null variable
        // Act
        stack.push(s); // Push that string onto the stack
        stack.dump(); // Show the contents of the stack
        String actual = outputStreamCaptor.toString().trim(); // Capture the output
        // Assert
        // Check if the output matches expected
        Assertions.assertEquals(actual, "Input was null. Value not added to the stack\r\n" + "Stack is empty"); 
    }

    /**
     * Tests that an element with a null value cannot be pushed onto a not empty stack
     */
    @Test
    @DisplayName("Test push() with null, not empty stack, dependant on dump()")
    public void pushTestNullDumpNotEmpty(){
        // Assign
        Stack stack = new Stack();
        String s = null; // Create a string with a null variable
        stack.push("A"); // Push 'A' onto the stack
        // Act
        stack.push(s); // Push null string onto the stack
        stack.dump(); // Show the contents of the stack
        String actual = outputStreamCaptor.toString().trim(); // Capture the output
        // Assert
        // Check if the output matches expected
        Assertions.assertEquals(actual, "Input was null. Value not added to the stack\r\n" + "A->"); 
    }

    /**
     * Tests pop() on an empty stack to ensure it returns null
     */
    @Test
    @DisplayName("Test pop(), empty stack")
    public void popTestEmpty(){
        // Assign
        Stack stack = new Stack(); // Initialize an empty stack
        // Act
        String actual = stack.pop(); // Initialize an empty stack
        // Assert
        Assertions.assertEquals(actual, null); // Ensure the returned value is null
    }

    /**
     * Tests pop() on a stack with one item to ensure correct item removal and return value
     */
    @Test
    @DisplayName("Test pop(), not empty, one item stack")
    public void popTestNotEmpty(){
        // Assign
        Stack stack = new Stack();  // Initialize stack
        stack.push("A"); // Push 'A' to stack
        // Act
        String actual = stack.pop(); // Pop an item
        // Assert
        Assertions.assertEquals(actual, "A"); // Check that the popped item is the one pushed
    }

    /**
     * Tests popping twice from a stack that only has one item to ensure the second pop returns null
     */
    @Test
    @DisplayName("Test pop(), one item stack, pop twice")
    public void popTestOneItemPopTwo(){
        // Assign
        Stack stack = new Stack(); // Initialize stack
        stack.push("A"); // Push 'A' to stack
        // Act
        stack.pop(); // First pop to remove 'A'
        String actual = stack.pop(); // Second pop should return null
        // Assert
        Assertions.assertEquals(actual, null); // Verify the result is null
    }

    /**
     * Tests pop() on a stack with two items to ensure items are popped in LIFO order
     */
    @Test
    @DisplayName("Test pop(), two item stack")
    public void popTestTwoItems(){
        // Assign
        Stack stack = new Stack(); // Initialize stack
        stack.push("A"); // Push 'A'
        stack.push("B"); // Push 'B' on top
        // Act
        String actual = stack.pop(); // Pop the top item
        // Assert
        Assertions.assertEquals(actual, "B"); // Ensure 'B' is popped first
    }

    /**
     * Tests popping all items from a stack filled with multiple items to ensure the stack is empty at the end
     * Use the isEmpty() method to facilitate that
     */
    @Test
    @DisplayName("Test pop(), multiple item stack, pop all until empty, dependant on isEmpty()")
    public void popTestMultiplePopAll(){
        // Assign
        Stack stack = new Stack(); // Initialize stack
        stack.push("A"); // Push 'A'
        stack.push("B"); // Push 'B'
        stack.push("C"); // Push 'C'
        stack.push("D"); // Push 'D'
        // Act
        while (!stack.isEmpty()) { // Loop until stack is empty
            stack.pop(); // Pop each item
        }
        String actual = stack.pop(); // Pop once more because stack is now empty which should return null
        // Assert
        Assertions.assertEquals(actual, null); // Verify the result is null
    }

    /**
     * Tests peek() on an empty stack to ensure it returns an appropriate message
     */
    @Test
    @DisplayName("Test peek(), empty stack")
    public void peekTestEmpty(){
        // Assign
        Stack stack = new Stack(); // Initialize an empty stack
        // Act
        String actual = stack.peek(); // Peek should return a message since stack is empty
        // Assert
        Assertions.assertEquals(actual, "Stack is empty"); // Check the message
        
    }

    /**
     * Tests peek() on a stack with an item to ensure it returns the top item
     */
    @Test
    @DisplayName("Test peek(), not empty stack")
    public void peekTestNotEmpty(){
        // Assign
        Stack stack = new Stack(); // Initialize stack
        stack.push("A"); // Push 'A'
        // Act
        String actual = stack.peek(); // Check the top of the stack. Peek should return 'A'
        // Assert
        Assertions.assertEquals(actual, "A"); // Check the value returned
    }

    /**
     * Tests peek() on a stack with multiple items to ensure it returns the top item
     */
    @Test
    @DisplayName("Test peek(), not empty and multiple items stack")
    public void peekTestNotEmptyMult(){
        // Assign
        Stack stack = new Stack(); // Initialize stack
        stack.push("A"); // Push 'A'
        stack.push("B"); // Push 'B'
        stack.push("C"); // Push 'C'
        stack.push("D"); // Push 'D'
        // Act
        String actual = stack.peek(); // Check the top of the stack. Peek should return 'D'
        // Assert
        Assertions.assertEquals(actual, "D");
    }

    /**
     * Tests peek() after push and pop operations to verify the current top of the stack
     */
    @Test
    @DisplayName("Test peek(), after push and pop")
    public void peekTestAfterPushAndPop(){
        // Assign
        Stack stack = new Stack(); // Initialize stack
        stack.push("A"); // Push 'A'
        stack.push("B"); // Push 'B'
        stack.pop(); // Pop 'B'
        // Act
        String actual = stack.peek(); // Check the top of the stack. Peek should return 'A'
        // Assert
        Assertions.assertEquals(actual, "A"); // Verify 'A' is the top of the stack
    }

    /**
     * Tests isEmpty() on an empty stack to confirm it returns true
     */
    @Test
    @DisplayName("Test isEmpty(), empty stack")
    public void isEmptyTestEmpty(){
        // Assign
        Stack stack = new Stack(); // Initialize an empty stack
        // Act
        boolean actual = stack.isEmpty(); // Check if stack is empty. Should return True
        // Assert
        Assertions.assertTrue(actual); // Verify that the stack is empty
    }

    /**
     * Tests isEmpty() on a stack that is not empty to confirm it returns false
     */
    @Test
    @DisplayName("Test isEmpty(), not empty stack")
    public void isEmptyTestNotEmpty(){
        // Assign
        Stack stack = new Stack(); // Initialize an empty stack
        stack.push("A"); // Push 'A'
        // Act
        boolean actual = stack.isEmpty(); // Check if stack is empty. Should return False
        // Assert
        Assertions.assertFalse(actual); // Verify that the stack is not empty
    }

    /**
     * Tests isEmpty() on a stack with multiple items to confirm it returns false
     */
    @Test
    @DisplayName("Test isEmpty(), not empty and multiple items stack")
    public void isEmptyTestNotEmptyMult(){
        // Assign
        Stack stack = new Stack(); // Initialize an empty stack
        stack.push("A"); // Push 'A'
        stack.push("B"); // Push 'B'
        stack.push("C"); // Push 'C'
        stack.push("D"); // Push 'D'
        // Act
        boolean actual = stack.isEmpty(); // Check if stack is empty. Should return False
        // Assert
        Assertions.assertFalse(actual); // Verify that the stack is not empty
    }

    @Test
    @DisplayName("Test isEmpty(), after pushing and popping one value")
    public void isEmptyTestAfterPushAndPop(){
        // Assign
        Stack stack = new Stack(); // Initialize an empty stack
        stack.push("A"); // Push 'A'
        stack.pop(); // Pop the top of the stack, i.e. 'A'
        // Act
        boolean actual = stack.isEmpty(); // Check if stack is empty. Should return True
        // Assert
        Assertions.assertTrue(actual); // Verify that the stack is empty after pushing and popping one item
    }

    /**
     * Tests length() on an empty stack to ensure it correctly reports a length of 0
     */
    @Test
    @DisplayName("Test length(), empty")
    public void lengthTestEmpty(){
        // Assign
        Stack stack = new Stack(); // Initialize an empty stack
        // Act
        int actual = stack.length(); // Get the length of the stack
        // Assert
        Assertions.assertEquals(actual, 0); // Confirm that the length is reported as 0
    }

    /**
     * Tests length() on a stack with one item to ensure it correctly reports a length of 1
     */
    @Test
    @DisplayName("Test length(), not empty, one value")
    public void lengthTestNotEmpty(){
        // Assign
        Stack stack = new Stack(); // Initialize an empty stack
        stack.push("A"); // Push 'A'
        // Act 
        int actual = stack.length(); // Get the length of the stack
        // Assert
        Assertions.assertEquals(actual, 1); // Confirm that the length is reported as 1
    }

    /**
     * Tests length() on a stack after multiple pushes to ensure it accurately counts the items
     */
    @Test
    @DisplayName("Test length(), after pushing multiple values")
    public void lengthTestPushMult(){
        // Assign
        Stack stack = new Stack(); // Initialize an empty stack
        stack.push("A"); // Push 'A'
        stack.push("B"); // Push 'B'
        stack.push("C"); // Push 'C'
        stack.push("D"); // Push 'D'
        // Act
        int actual = stack.length(); // Get the length of the stack
        // Assert
        Assertions.assertEquals(actual, 4); // Confirm that the length is reported as 4
    }

    /**
     * Tests dump() on an empty stack to ensure it correctly outputs 'Stack is empty'
     */
    @Test
    @DisplayName("Test dump(), empty")
    public void dumpTestEmpty(){
        // Assign
        Stack stack = new Stack(); // Initialize an empty stack
        // Act
        stack.dump(); // Attempt to dump contents of the stack
        String actual = outputStreamCaptor.toString().trim(); // Get the output
        // Assert
        Assertions.assertEquals(actual, "Stack is empty"); // Check if the output matches the expected message
    }
    
    /**
     * Tests dump() on a stack with one item to ensure it correctly outputs the item followed by '->'
     */
    @Test
    @DisplayName("Test dump(), not empty")
    public void dumpTestNotEmpty(){
        // Assign
        Stack stack = new Stack(); // Initialize stack
        stack.push("A"); // Push 'A' to stack
        // Act
        stack.dump(); // Dump the contents of the stack
        String actual = outputStreamCaptor.toString().trim(); // Get the output
        // Assert
        Assertions.assertEquals(actual, "A->"); // Confirm the output format is correct
    }

    /**
     * Tests the dump operation after multiple pushes to ensure it correctly outputs all items in LIFO order
     */
    @Test
    @DisplayName("Test dump(), multiple pushes ")
    public void dumpTestMultPush(){
        // Assign
        Stack stack = new Stack(); // Initialize stack
        stack.push("A"); // Push 'A'
        stack.push("B"); // Push 'B'
        stack.push("C"); // Push 'C'
        stack.push("D"); // Push 'D'
        // Act
        stack.dump(); // Dump the contents of the stack
        String actual = outputStreamCaptor.toString().trim(); // Get the output
        // Assert
        Assertions.assertEquals(actual, "D->C->B->A->"); // Confirm that items are output in correct order  
    }

    /**
     * Tests the dump operation after multiple pushes followed by two pops, to ensure the remaining items are correctly output
     */
    @Test
    @DisplayName("Test dump(), multiple pushes, two pops")
    public void dumpTestMultPushTwoPop(){
        // Assign
        Stack stack = new Stack(); // Initialize stack
        stack.push("A"); // Push 'A'
        stack.push("B"); // Push 'B'
        stack.push("C"); // Push 'C'
        stack.push("D"); // Push 'D'
        stack.pop(); // Pop 'D'
        stack.pop(); // Pop 'C'
        // Act
        stack.dump(); // Dump the contents of the stack
        String actual = outputStreamCaptor.toString().trim(); // Get the output
        // Assert
        Assertions.assertEquals(actual, "B->A->"); // Confirm that the remaining items are output in correct order
    }
}