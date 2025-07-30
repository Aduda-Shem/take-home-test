import java.util.*;

public class Question1_GetLongestString {

    /**
     * Returns the longest string from the array that:
     * - Contains only allowed characters.
     * - Has no repeated identical adjacent characters.
     */
    public static String getLongestString(List<String> chars, String[] arr) {

        // Here we implement HashSet for fast lookups 
        Set<String> allowed = new HashSet<>(chars);
        String longest = "";

        for (String s : arr) {
            if (isValid(s, allowed) && s.length() > longest.length()) {
                longest = s;
            }
        }

        return longest;
    }

    // Checks if the string contains only allowed characters and no repeats
    private static boolean isValid(String s, Set<String> allowed) {
        for (int i = 0; i < s.length(); i++) {
            String ch = String.valueOf(s.charAt(i));
            if (!allowed.contains(ch)) 
            return false;
            if (i > 0 && s.charAt(i) == s.charAt(i - 1)) 
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        List<String> chars = Arrays.asList("A", "B", "C", "D");
        String[] arr = {"AABCDA", "ABCDZADC", "ABCDBCA", "ABCDABDCA"};
        System.out.println(getLongestString(chars, arr));

        List<String> chars2 = Arrays.asList("A", "B");
        String[] arr2 = {"ABAB", "BABA"};
        System.out.println(getLongestString(chars2, arr2)); 

        List<String> chars3 = Arrays.asList("A", "B", "C", "D", "E");
        String[] arr3 = {"ABC", "ABCD", "ABCDE"};
        System.out.println(getLongestString(chars3, arr3));
    }
}
