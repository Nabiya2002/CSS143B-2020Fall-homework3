/**
 * Author: Nabiya Alam
 * Version: 1.0.0
 * Date: 10/25/2020
 */
package Problem2;

// all functions assume using dummy node
public class SingleLinkedList {
    // do not add member variables
    private final ListNode head;
    private int size;

    public SingleLinkedList() {
        head = new ListNode();  // dummy node
    }

    // copy constructor
    public SingleLinkedList(SingleLinkedList list) {
        this();
        ListNode otherCurrent = list.head.next;
        ListNode thisCurrent = head;

        while (otherCurrent != null) {
            thisCurrent.next = new ListNode(otherCurrent.val);
            otherCurrent = otherCurrent.next;
            thisCurrent = thisCurrent.next;
        }
        size = list.size;
    }

    public SingleLinkedList(int[] data) {
        this();
        if (data == null) {
            return;
        }
        ListNode ptr = head;
        for (int datum : data) {
            ptr.next = new ListNode(datum);
            ptr = ptr.next;
            size++;
        }
    }

    // goes through the list and removes any node that matches valueToRemove
    public int removeAll(int valueToRemove) {
        ListNode prev = head;
        ListNode curr = head.next;

        int removed = 0;

        while (curr != null) {
            if (curr.val == valueToRemove) {

                prev.next = curr.next;
                curr.next = null;
                curr = prev.next;

                removed++;

                // also need to reduce the size when a node is removed
                // to maintain correct count
                size--;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return removed;
    }

// do not change any function below

    // reverse the linked list nodes iteratively (no recursion)
    public void reverse() {
        ListNode prev = null;
        ListNode current = head.next;

        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        head.next = prev;
    }

    // Appends the specified element to the end of this list
    public void add(int val) {
        size++;
        ListNode ptr = head;
        while (ptr.next != null) {
            ptr = ptr.next;
        }
        ptr.next = new ListNode(val);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        ListNode ptr = head.next;
        while (ptr != null) {
            builder.append(ptr.val).append(ptr.next == null ? " -> end " : " -> ");
            ptr = ptr.next;
        }
        return builder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof SingleLinkedList)) {
            return false;
        }

        SingleLinkedList otherList = (SingleLinkedList) obj;

        if (this.size != otherList.size) {
            return false;
        }
        ListNode n1 = head.next;
        ListNode n2 = otherList.head.next;
        while (n1 != null && n2 != null) {
            if (n1.val != n2.val) {
                return false;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        return (n1 == null && n2 == null);
    }

    public int getSize() {
        return size;
    }
}
