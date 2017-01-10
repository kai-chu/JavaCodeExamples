package effective.java.item6.ObsoleteObjects;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ObsoleteObject {
	private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public ObsoleteObject() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public Object push(Object e) {
        ensureCapacity();
       // elements[size++] = e; 
        
        Object result = elements[--size];
        elements[size] = null; // Eliminate obsolete reference
        return result;

    }

    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        return elements[--size];
    }

    /**
     * Ensure space for at least one more element, roughly
     * doubling the capacity each time the array needs to grow.
     */
    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }

}
