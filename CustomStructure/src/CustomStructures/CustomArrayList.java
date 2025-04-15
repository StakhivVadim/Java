//Собственный аналог ArrayList
package CustomStructures;

import java.util.Arrays;

public class CustomArrayList<T> {
	
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size = 0;

    public CustomArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public void add(T value) {
    	checkSize();
        elements[size++] = value;
    }

    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    public void remove(int index) {
        checkIndex(index);
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;
    }

    public void addAll(T[] values) {
        for (T value : values) {
            add(value);
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс " + index + " вне диапазона");
        }
    }

    private void checkSize() {
        if (size == elements.length) {
            int newCapacity = elements.length * 2;
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    public int size() {
        return size;
    }
    
    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(elements, size));
    }

}
