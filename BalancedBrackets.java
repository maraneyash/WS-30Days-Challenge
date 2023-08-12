import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {
    public static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false; // Unbalanced if closing bracket with no corresponding opening bracket
                }

                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
                    return false; // Unbalanced if closing bracket doesn't match top of stack
                }
            }
        }

        return stack.isEmpty(); // If stack is empty, all brackets are balanced
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        boolean result = isBalanced(inputString);
        if (result) {
            System.out.println("The string is balanced.");
        } else {
            System.out.println("The string is not balanced.");
        }

        scanner.close();
    }
}
