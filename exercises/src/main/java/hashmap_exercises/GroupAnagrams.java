package hashmap_exercises;

import java.util.*;

/**
 * LeetCode 49 - Group Anagrams
 *
 * Given an array of strings strs, group the anagrams together.
 * You can return the answer in any order.
 *
 * Example:
 * Input:  ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]] (order may vary)
 */
public class GroupAnagrams {

    /**
     * Groups the given words into lists of anagrams.
     *
     * @param strs array of input strings
     * @return a list of groups, where each group is a list of anagrams
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        // TODO: implement
        // Typical approach:
        // - For each string, sort its characters to get a "canonical form"
        // - Use a Map<String, List<String>>: canonicalForm -> list of words
        // - Return the map's values as the result
        Map<String, List<String>> anagramGroups = new HashMap<>();

        // Process each string
        for (String str : strs) {
            // Convert string to char array and sort it to get canonical form
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String canonicalForm = new String(chars);

            // If this canonical form hasn't been seen before, create a new list
            if (!anagramGroups.containsKey(canonicalForm)) {
                anagramGroups.put(canonicalForm, new ArrayList<>());
            }

            // Add the original string to the appropriate group
            anagramGroups.get(canonicalForm).add(str);
        }

        // Return all the grouped anagrams as a list of lists
        return new ArrayList<>(anagramGroups.values());
    }
}

