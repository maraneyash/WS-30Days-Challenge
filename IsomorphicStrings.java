import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IsomorphicStrings {
    public static boolean areIsomorphic(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        Map<Character, Character> mapping = new HashMap<>();
        Map<Character, Boolean> usedChars = new HashMap<>();

        for (int i = 0; i < str1.length(); i++) {
            char char1 = str1.charAt(i);
            char char2 = str2.charAt(i);

            if (mapping.containsKey(char1)) {
                if (mapping.get(char1) != char2) {
                    return false;
                }
            } else {
                if (usedChars.containsKey(char2)) {
                    return false;
                }
                mapping.put(char1, char2);
                usedChars.put(char2, true);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first string: ");
        String str1 = scanner.nextLine();

        System.out.print("Enter the second string: ");
        String str2 = scanner.nextLine();

        boolean result = areIsomorphic(str1, str2);
        if (result) {
            System.out.println("The strings are isomorphic.");
        } else {
            System.out.println("The strings are not isomorphic.");
        }

        scanner.close();
    }
}
