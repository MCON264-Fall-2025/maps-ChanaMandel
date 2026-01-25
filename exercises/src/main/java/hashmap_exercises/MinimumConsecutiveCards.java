package hashmap_exercises;


import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 2260 - Minimum Consecutive Cards to Pick Up
 *
 * You are given an integer array cards where cards[i] represents the value of the i-th card.
 * You need to pick up a sequence of cards (a contiguous subarray) that contains at least
 * two cards with the same value.
 *
 * Return the minimum length of such a subarray, or -1 if it is impossible.
 *
 * Example:
 * cards = [3, 4, 2, 3, 4, 7] -> answer = 4
 * (e.g., subarray [3, 4, 2, 3] from index 0 to 3)
 */
public class MinimumConsecutiveCards {

    /**
     * @param cards array of card values
     * @return minimum length of a contiguous subarray containing two equal cards,
     *         or -1 if no such subarray exists
     */
    public int minimumCardPickup(int[] cards) {
        // TODO: implement using a Map<Integer, Integer> to track last seen indices
        // High-level hint:
        // - Keep a map from cardValue -> lastIndexSeen
        // - For each index i:
        //     if cardValue was seen at j, update answer with (i - j + 1)
        //     then update lastIndexSeen for this cardValue to i
        // - If you never update the answer, return -1
        Map<Integer, Integer> lastSeenIndex = new HashMap<>();

        // Initialize answer to a large value (or use Integer.MAX_VALUE)
        int minLength = Integer.MAX_VALUE;

        // Iterate through each card
        for (int i = 0; i < cards.length; i++) {
            int cardValue = cards[i];

            // If we've seen this card before
            if (lastSeenIndex.containsKey(cardValue)) {
                // Get the previous index where this card was seen
                int prevIndex = lastSeenIndex.get(cardValue);

                // Calculate the length of the subarray
                int length = i - prevIndex + 1;

                // Update minimum length
                minLength = Math.min(minLength, length);
            }

            // Update the last seen index for this card value
            lastSeenIndex.put(cardValue, i);
        }

        // If we never found a duplicate, return -1
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}
