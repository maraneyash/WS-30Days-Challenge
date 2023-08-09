import java.util.Scanner;

public class StringReversal {

    public static String reverseString(String str) {

        if (str.isEmpty() || str.length() == 1)
            return str;

        return reverseString(str.substring(1)) + str.charAt(0);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        String reversedString = reverseString(inputString);
        System.out.println("Reversed string: " + reversedString);

        scanner.close();
    }
}
