/**
 * Author: Nabiya Alam
 * Version: 1.0.0
 * Date: 10/25/2020
 */
package Problem1;

public class ArrayStack<T> implements Stack<T> {
    // do not change member variables
    private final T[] data;
    private final int capacity;
    private int size;

    private ArrayStack() {
        this.capacity = 10;
        data = (T[]) new Integer[capacity];
    }

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        data = (T[]) new Integer[capacity];
    }

    @Override
    public boolean push(T val) {
        if (size < capacity) {
            data[size++] = val;
            return true;
        }
        return false;
    }

    @Override
    public T pop() {
        T val = null;
        if (size > 0) {
            val = data[--size];
        }
        return val;
    }

    @Override
    public T peek() {
        T val = null;

        if (size > 0) {
            val = data[size - 1];
        }
        return val;
    }

    @Override
    public int size() {
        return size;
    }
}
