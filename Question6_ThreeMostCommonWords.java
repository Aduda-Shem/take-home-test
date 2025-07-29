import java.util.*;
import java.util.stream.Collectors;

public class Question6_ThreeMostCommonWords {

    public static String[] findThreeMostCommonWords(String sentence) {
        // Here we convert to lowercase
        String[] words = sentence.toLowerCase().split("\\s+");

        // Count occurrences of each word by using O(1) time complexity
        Map<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        // Sort top 3 entries by frequency
        return freq.entrySet().stream()
                .sorted((a, b) -> {
                    int cmp = b.getValue().compareTo(a.getValue());
                    return cmp != 0 ? cmp : a.getKey().compareTo(b.getKey());
                })
                .limit(3)
                .map(Map.Entry::getKey)
                // sort alphabetically
                .sorted()
                .toArray(String[]::new);
    }

    public static void main(String[] args) {
        String s1 = "hi there care to discuss algorithm basis or how to solve algorithm or";
        // Output: [algorithm, or, to]
        System.out.println(Arrays.toString(findThreeMostCommonWords(s1)));

        String s2 = "";
        // Output: []
        System.out.println(Arrays.toString(findThreeMostCommonWords(s2)));
    }
}
