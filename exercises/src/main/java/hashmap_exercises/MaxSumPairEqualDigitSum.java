package hashmap_exercises;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 2342 - Max Sum of a Pair With Equal Sum of Digits
 *
 * You are given a 0-indexed integer array nums.
 * Find the maximum sum of a pair of numbers (nums[i] + nums[j]) such that
 * the sum of digits of nums[i] is equal to the sum of digits of nums[j],
 * and i != j.
 *
 * If no such pair exists, return -1.
 *
 * Example:
 * nums = [18, 43, 36, 13, 7]
 * digit sums: 9, 7, 9, 4, 7
 * Pairs with same digit sum:
 *   (18, 36) -> sum = 54 with digit sum 9
 *   (43, 7)  -> sum = 50 with digit sum 7
 * Answer: 54
 */
public class MaxSumPairEqualDigitSum {

    /**
     * @param nums input array
     * @return maximum sum of a pair of numbers sharing the same digit sum,
     *         or -1 if no such pair exists
     */
    public int maximumSum(int[] nums) {
        // TODO: implement
        // Common approach:
        // - For each number, compute its digit sum.
        // - Use a Map<Integer, Integer> digitSum -> highest number seen with this digit sum.
        // - For each number:
        //     if we already have a value for this digit sum,
        //        update answer with (nums[i] + bestSoFar),
        //        and update bestSoFar if nums[i] is larger.
        //     else,
        //        store nums[i] as bestSoFar.
        // - Return answer.
        Map<Integer, Integer> digitSumToMax = new HashMap<>();

        // Track the maximum sum found
        int maxSum = -1;

        // Process each number
        for (int num : nums) {
            // Calculate the digit sum for the current number
            int dSum = digitSum(num);

            // If we've seen another number with the same digit sum
            if (digitSumToMax.containsKey(dSum)) {
                // Calculate the pair sum
                int pairSum = num + digitSumToMax.get(dSum);

                // Update the maximum sum
                maxSum = Math.max(maxSum, pairSum);

                // Update the maximum value for this digit sum
                digitSumToMax.put(dSum, Math.max(digitSumToMax.get(dSum), num));
            } else {
                // First time seeing this digit sum, store the number
                digitSumToMax.put(dSum, num);
            }
        }

        return maxSum;
    }

    /**
     * Optional helper method:
     * Computes the sum of digits of a non-negative integer.
     */
    int digitSum(int x) {
        // TODO (optional): implement and use it from maximumSum
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}

