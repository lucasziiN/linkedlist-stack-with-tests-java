
public class Main {
    public static void main(String[] args) {
        //private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        Stack stack = new Stack();

        System.out.println("Adding to the stack");
        String s = null;
        stack.push("A");
        stack.push(s);
        stack.dump();
        //String actual = outputStreamCaptor.toString().trim();
        
        /*stack.push("A");
        System.out.println(stack.length());
        System.out.println(stack.peek());
        stack.push("B");
        System.out.println(stack.length());
        System.out.println(stack.peek());
        stack.push("C");
        System.out.println(stack.length());
        System.out.println(stack.peek());
        stack.dump();
        
        System.out.println("Removing from the stack");
        //System.out.println(stack.peek());
        System.out.println(stack.pop());
        //System.out.println(stack.peek());
        System.out.println(stack.pop());
        //System.out.println(stack.peek());
        System.out.println(stack.pop());
        //System.out.println(stack.peek());
        stack.pop();
        stack.dump();
        
        System.out.println();
        System.out.println("Stack is empty: " + stack.isEmpty());
        System.out.println(stack.length());
        stack.push("Z");
        System.out.println("Stack is empty: " + stack.isEmpty());
        System.out.println(stack.length());
        System.out.println(stack.peek());
        stack.dump();*/
    
    }
}