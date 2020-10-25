/**
 * This code prints a single linked list in reverse order. It uses a LinkedList Stack to help reverse
 * it.
 * <p>
 * Author: Nabiya Alam
 * Version: 1.0.0
 * Date: 10/25/2020
 */
package Problem3;

import Problem1.LinkedListStack;
import Problem2.ListNode;

import java.io.PrintStream;

public class Problem3 {

    public static void printListInReverse(ListNode list, PrintStream print) {
        if (list == null) {
            return;
        }

        // LinkedIntList stack as storage to reverse the order
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        ListNode current = list.next;

        // add values to aux stack
        while (current != null) {
            stack.push(current.val);
            current = current.next;
        }

        // popping the stack gives the values in reverse
        while (stack.size() > 0) {
            print.println(stack.pop());
        }
    }
}

