import java.util.*;

public class Question4_FirstUniqueProduct {

    /**
     * find the first product in an array that occurs only once in that array.
     */
    public static String firstUniqueProduct(String[] arr) {
        // Here , we count of each product - preserving insertion order
        Map<String, Integer> count = new LinkedHashMap<>();

        for (String product : arr) {
            count.put(product, count.getOrDefault(product, 0) + 1);
        }

        // Return the first product with count == 1
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            if (entry.getValue() == 1) return entry.getKey();
        }

        return null; 
    }

    public static void main(String[] args) {
        String[] a = {"Apple", "Computer", "Apple", "Bag"};
         // Computer
        System.out.println(firstUniqueProduct(a));

        String[] c = {};
        // null
        System.out.println(firstUniqueProduct(c)); 
    }
}
