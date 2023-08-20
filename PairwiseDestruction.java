import java.util.Scanner;
import java.util.Stack;

public class PairwiseDestruction {
    public static int countRemainingWords(String[] words) {
        Stack<String> stack = new Stack<>();

        for (String word : words) {
            if (!stack.isEmpty() && stack.peek().equals(word)) {
                stack.pop();
            } else {
                stack.push(word);
            }
        }

        return stack.size();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of words: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        String[] words = new String[n];
        System.out.println("Enter the words:");
        for (int i = 0; i < n; i++) {
            words[i] = scanner.next();
        }

        int remainingWords = countRemainingWords(words);
        System.out.println("Number of words left after pairwise destruction: " + remainingWords);

        scanner.close();
    }
}
