class Solution {
    // Single pass: increment for s, decrement for t simultaneously.
    // All frequencies cancel to 0 if truly anagrams.
    // Early exit: length check before array allocation.
    // O(n) time, O(1) space — int[26] beats HashMap for lowercase input.
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] isVisited = new int[26];
        for (int i = 0; i < s.length(); i++) {
            isVisited[s.charAt(i) - 'a']++;
            isVisited[t.charAt(i) - 'a']--;
        }

        for (int num : isVisited) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }
}