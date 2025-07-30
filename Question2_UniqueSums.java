import java.util.*;

public class Question2_UniqueSums {

    /**
     * check how many unique ways the array's numbers can be added to match the result.
     */
    public static int countUniqueSumWays(int target, int[] numbers) {
        List<List<Integer>> results = new ArrayList<>();
        backtrack(numbers, 0, target, new ArrayList<>(), results);
        return results.size();
    }

    // Recursive backtracking to find combinations that sum to the target
    private static void backtrack(int[] nums, int index, int remaining, List<Integer> path, List<List<Integer>> results) {
        if (remaining == 0) {
            results.add(new ArrayList<>(path));
            return;
        }
        if (remaining < 0 || index >= nums.length) 
        return;

        // Include current number
        path.add(nums[index]);
        backtrack(nums, index + 1, remaining - nums[index], path, results);

        // Exclude current number
        path.remove(path.size() - 1);
        backtrack(nums, index + 1, remaining, path, results);
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int expected1 = 3;
        int result1 = countUniqueSumWays(10, arr1);
        System.out.println("Test 1: " + (result1 == expected1 ? "PASSED" : "FAILED"));

        int[] arr2 = {2, 4, 6};
        int expected2 = 0;
        int result2 = countUniqueSumWays(5, arr2);
        System.out.println("Test 2: " + (result2 == expected2 ? "PASSED" : "FAILED"));

        int[] arr3 = {};
        int expected3 = 1;
        int result3 = countUniqueSumWays(0, arr3);
        System.out.println("Test 3: " + (result3 == expected3 ? "PASSED" : "FAILED"));
    }
}
