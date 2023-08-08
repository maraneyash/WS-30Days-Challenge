import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AnagramCheck {

    public static boolean areAnagrams(String str1, String str2) {

        str1 = str1.replaceAll("[^a-zA-Z]", "").toLowerCase();
        str2 = str2.replaceAll("[^a-zA-Z]", "").toLowerCase();

        if (str1.length() != str2.length())
            return false;

        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char c : str1.toCharArray())
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);

        for (char c : str2.toCharArray()) {
            if (!charCountMap.containsKey(c))
                return false;

            charCountMap.put(c, charCountMap.get(c) - 1);
            if (charCountMap.get(c) == 0)
                charCountMap.remove(c);

        }

        return charCountMap.isEmpty();
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String str1 = input.nextLine();

        System.out.print("Enter second string: ");
        String str2 = input.nextLine();

        input.close();

        boolean result = areAnagrams(str1, str2);
        System.out.println("Are the strings anagrams? " + result);
    }
}
