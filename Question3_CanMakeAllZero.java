import java.util.*;

public class Question3_CanMakeAllZero {

    /**
     * Returns 1 if all elements except the first can be made zero
     * by repeatedly applying: a[i] = a[i] - a[i-1], for i >= 1.
     * Otherwise returns 0.
     */
    public static int canMakeArrayAllZero(int[] input) {
        if (input.length <= 1) 
            return 1;

        int[] numbers = Arrays.copyOf(input, input.length);
        int maxTries = 1000;

        for (int i = 0; i < maxTries; i++) {
            if (allExceptFirstAreZero(numbers)) return 1;
            if (!applyStep(numbers)) break;
        }

        return allExceptFirstAreZero(numbers) ? 1 : 0;
    }

    // Checks if all elements after index 0 are zero
    private static boolean allExceptFirstAreZero(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] != 0) return false;
        }
        return true;
    }

    // Applies one valid reduction step from right to left
    private static boolean applyStep(int[] numbers) {
        for (int i = numbers.length - 1; i >= 1; i--) {
            if (numbers[i] >= numbers[i - 1] && numbers[i] > 0) {
                numbers[i] -= numbers[i - 1];
                return true;
            }
        }
        return false;
    }

public static void main(String[] args) {
    int[] a = {1, 2, 3};
    int expected1 = 1;
    int result1 = canMakeArrayAllZero(a);
    System.out.println("Test 1: " + (result1 == expected1 ? "PASSED" : "FAILED"));

    int[] b = {6, 3};
    int expected2 = 0;
    int result2 = canMakeArrayAllZero(b);
    System.out.println("Test 2: " + (result2 == expected2 ? "PASSED" : "FAILED"));

    int[] c = {7};
    int expected3 = 1;
    int result3 = canMakeArrayAllZero(c);
    System.out.println("Test 3: " + (result3 == expected3 ? "PASSED" : "FAILED"));

    int[] d = {};
    int expected4 = 1;
    int result4 = canMakeArrayAllZero(d);
    System.out.println("Test 4: " + (result4 == expected4 ? "PASSED" : "FAILED"));
}
}
