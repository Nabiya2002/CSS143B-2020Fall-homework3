/**
 * Author: Nabiya Alam
 * Version: 1.0.0
 * Date: 10/25/2020
 */
package Problem1;

public class ValidParentheses {

    // Do not change signature (function name, parameters, return type)
    public static boolean isValid(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }

        // decided to use LinkedListStack to avoid the top limit
        LinkedListStack<Character> stack = new LinkedListStack<>();

        // The code iterates through the string one character at a time and
        // checks that they are all valid parentheses and if not returns false;
        // if it is a valid open parentheses, push it to the stack
        for (char c : str.toCharArray()) {
            //check that the characters are valid parentheses
            if (c != '(' && c != '{' && c != '['
                    && c != ')' && c != '}' && c != ']') {
                return false;
            }

            //if it is an open parentheses, push to stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                //ensure that stack is not empty
                if (stack.size() == 0) {
                    return false;
                }
                char openParen = stack.pop();

                // if a char does not match one of the following return false
                if ((c == ']' && openParen != '[') ||
                        (c == ')' && openParen != '(')
                        || (c == '}' && openParen != '{')) {
                    return false;
                }
            }
        }

        return stack.size() == 0;
    }
}
