import java.util.*;

public class Question4_FirstUniqueProduct {

    /**
     * Returns the first string that appears only once in the array.
     */
    public static String firstUniqueProduct(String[] arr) {
        // Here , we count of each product - using LinkedHashMap preserving insertion order
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

        String[] b = {"Apple", "Bag", "Computer", "Apple"};
         // Bag
        System.out.println(firstUniqueProduct(b));

        String[] c = {};
        // null
        System.out.println(firstUniqueProduct(c)); 

  
    }
}
