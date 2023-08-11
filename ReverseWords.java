import java.util.Scanner;

public class ReverseWords {

    public static String reverseWords(String str) {

        String[] words = str.split(" ");
        StringBuilder reversed = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--)
            reversed.append(words[i]).append(" ");

        return reversed.toString().trim();
    }

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        String reversedString = reverseWords(inputString);
        System.out.println("Reversed string word by word: " + reversedString);

        scanner.close();
    }
}
