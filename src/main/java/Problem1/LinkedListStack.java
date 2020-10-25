/**
 * Author: Nabiya Alam
 * Version: 1.0.0
 * Date: 10/25/2020
 */
package Problem1;

import java.util.LinkedList;

public class LinkedListStack<T> implements Stack<T> {
    // use Java LinkedList to store the data
    // do not change member variables
    private final LinkedList<T> data;

    public LinkedListStack() {
        data = new LinkedList<>();
    }

    @Override
    public boolean push(T val) {
        data.addFirst(val);
        return true;
    }

    @Override
    public T pop() {
        T val = null;
        if (data.size() > 0) {
            val = data.removeFirst();
        }
        return val;
    }

    @Override
    public T peek() {
        T val = null;
        if (data.size() > 0) {
            val = data.getFirst();
        }
        return val;
    }

    @Override
    public int size() {
        return data.size();
    }
}
