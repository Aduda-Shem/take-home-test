import java.util.*;

public class Question5_ClosestMinimumsDistance {

    /**
     * Finds the distance between the two closest occurrences of the minimum value in the array.
     */
    public static int findClosestMinimumsDistance(int[] numbers) {
        // Here we find the smallest number in array
        int minValue = Arrays.stream(numbers).min().getAsInt();
        List<Integer> minPositions = new ArrayList<>();

        // Store all indices where the minimum value occurs
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == minValue) {
                minPositions.add(i);
            }
        }

        // Find the smallest gap between consecutive minimum positions
        int smallestGap = Integer.MAX_VALUE;
        for (int i = 1; i < minPositions.size(); i++) {
            int gap = minPositions.get(i) - minPositions.get(i - 1);
            smallestGap = Math.min(smallestGap, gap);
        }

        return smallestGap;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 1, 4, 5, 2};
        // 3
        System.out.println(findClosestMinimumsDistance(a)); 

        int[] b = {1, 2, 3, 4, 1};
         // 4
        System.out.println(findClosestMinimumsDistance(b));

        int[] c = {2, 2, 2, 2};
        // 1
        System.out.println(findClosestMinimumsDistance(c)); 
    }
}
