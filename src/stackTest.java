import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class stackTest {
    @Test
    public void stack() {
        try {
            // Create a new stack, default capacity of 20
            stack<Integer> stack = new stack<>();

            // Push 20 items into stack
            for (int i = 0; i < 20; i++) {
                stack.push(i);
            }
        }
        catch (FullStackException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void stackWithSpecifiedCapacity() {
        int capacity = 30;

        stack<Integer> stack = new stack<>(capacity);

        // Push 30 elements into stack
        for (int i = 0; i < 30; i++) {
            try {
                stack.push(i);
            }
            catch (FullStackException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void pop() throws EmptyStackException {
        // Create empty stack
        stack<Integer> stack = new stack<>();

        // Push items into empty array
        for (int i = 0; i < 5; i++) {
            try {
                stack.push(i);
            }
            catch (FullStackException e) {
                e.printStackTrace();
            }
        }

        // Pop values out of array stack (verify the same order as they were pushed)
        for (int i = 4; i >= 0; i--) {
            assertEquals(i, (int) stack.pop());
        }

        // Verify the stack is now empty
        assertEquals(stack.size(), 0);

        // If stack.pop() is called again, EmptyStackException should occur
        try {
            stack.pop();
            fail("EmptyStackException if pop is called on empty stack");
        }
        catch (EmptyStackException e) {
            // Print empty stack error message (commented out - uncomment for debugging)
            // System.out.println(e);
        }

        // creating a stack of capacity 3
        stack = new stack<>(3);
    }

    @Test
    void push() {
        // Create empty stack with default capacity of 20
        stack<Integer> stack = new stack<>();

        // Push 20 items into empty array
        for (int i = 0; i <= 19; i++) {
            try {
                stack.push(i);
            } catch (FullStackException e) {
                e.printStackTrace();
            }
        }

        // Verify stack is not empty
        assertFalse(stack.empty());

        // Try to push another value into stack, should produce stack full error
        try {
            stack.push(1);
            fail("FullStackException if push is called on full stack");
        }
        catch (FullStackException e) {
            // Print full stack error message (commented out - uncomment for debugging)
            // System.out.println(e);
        }
    }

    @Test
    void peek() {
        stack<Integer> stack = new stack<>();

        // Push items into stack and peek/verify the value at the top
        for (int i = 0; i < 5; i++) {
            try {
                stack.push(i);
            }
            catch (FullStackException e) {
                e.printStackTrace();
            }

            // Verify newly pushed value is at the top
            try {
                assertEquals(i, (int) stack.peek());
            }
            catch (EmptyStackException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    void empty() {
        // Create new, empty stack
        stack<Integer> stack = new stack<>();

        // Verify stack is empty
        assertTrue(stack.empty());

        // Push an item into the stack
        try {
            stack.push(1);
        }
        catch (FullStackException e) {
            e.printStackTrace();
        }

        // Verify that the stack is NOT empty now
        assertFalse(stack.empty());
    }
}