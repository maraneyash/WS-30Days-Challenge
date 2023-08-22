import java.util.Scanner;
import java.util.Stack;

public class ClosingBracketIndex {
    public static int findClosingBracketIndex(String str, int startIndex) {
        Stack<Integer> stack = new Stack<>();

        for (int i = startIndex; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '[')
                stack.push(i);
            else if (ch == ']') {
                if (stack.isEmpty())
                    return -1;

                if (stack.peek() == startIndex)
                    return i;

                stack.pop();
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string with brackets: ");
        String str = scanner.nextLine();

        System.out.print("Enter the index of the open bracket: ");
        int startIndex = scanner.nextInt();

        int closingIndex = findClosingBracketIndex(str, startIndex);
        if (closingIndex != -1) {
            System.out.println("Index of the closing bracket: " + closingIndex);
        } else {
            System.out.println("No matching closing bracket found");
        }

        scanner.close();
    }
}
