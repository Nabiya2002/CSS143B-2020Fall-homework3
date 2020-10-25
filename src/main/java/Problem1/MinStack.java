/**
 * Author: Nabiya Alam
 * Version: 1.0.0
 * Date: 10/25/2020
 */
package Problem1;

public class MinStack extends ArrayStack<Integer> {
    ArrayStack<Integer> minStack;

    public MinStack(int size) {
        super(size);
        minStack = new ArrayStack<>(size);
    }

    @Override
    public boolean push(Integer val) {
        boolean result = super.push(val);
        if (result) {
            // if val is less than the top value of the min stack
            // then you push it to minStack
            if (minStack.peek() == null || minStack.size() == 0) {
                minStack.push(val);
            } else {
                if (val > minStack.peek()) {
                    minStack.push(minStack.peek());
                } else {
                    minStack.push(val);
                }
            }

            return true;
        }
        return false;
    }


    @Override
    public Integer pop() {
        Integer value = super.pop();
        if (value != null) {
            minStack.pop();
        }

        return value;
    }

    public Integer getMin() {
        return minStack.peek();
    }
}

