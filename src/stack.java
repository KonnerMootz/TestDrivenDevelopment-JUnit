@SuppressWarnings({"unchecked"})
public class stack<E> {
    private final E[] array;
    private int size = 0;

    public stack() {
        // Creating array of size 20
        array = (E[]) new Object[20];
    }

    public stack(int capacity) {
        // Create new stack with user specified capacity
        array = (E[]) new Object[capacity];
    }

    public E pop() throws EmptyStackException {
        // If stack is empty, throw an error
        if (empty()) {
            throw new EmptyStackException();
        }

        // Get item at the top of the array
        E data = array[size - 1];

        size--;

        return data;
    }

    public void push(E item) throws FullStackException {
        // If stack is full, throw an error
        if (size == array.length) {
            throw new FullStackException();
        }

        // Add new item to the top of the stack
        array[size] = item;

        // Increase the size of the stack
        size++;
    }

    public E peek() throws EmptyStackException {
        // If the array is empty, throw an error
        if (empty()) {
            throw new EmptyStackException();
        }

        // Return the top element from array
        return array[size - 1];
    }

    public boolean empty() {
        boolean isEmpty;

        if (size <= 0) {
            isEmpty = true;
        }
        else {
            isEmpty = false;
        }

        return isEmpty;
    }

    public int size() {
        // Return current size of stack
        return size;
    }
}

// Provides full stack error
class FullStackException extends Exception {
    public FullStackException() {
        super("ERROR! The stack is full...");
    }
}

// Provides empty stack error
class EmptyStackException extends Exception {
    public EmptyStackException() {
        super("ERROR! The stack is empty...");
    }
}