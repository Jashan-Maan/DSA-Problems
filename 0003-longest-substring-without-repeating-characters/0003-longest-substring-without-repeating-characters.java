class Solution {
    // Sliding window: expand right, shrink left when duplicate found.
    // HashMap tracks char frequency in current window.
    // Bug watch: map.get(s.charAt(left)) - 1 not map.get(s.charAt(left) - 1)
    // Alternative: store index instead of count → left jumps directly, no while.
    // O(n) time, O(k) space where k = charset size.
    public int lengthOfLongestSubstring(String s) {
        int longestString = 0;

        for (int i = 0; i < s.length(); i++) {
            HashSet<Character> set = new HashSet<>();
            int stringSize = 0;
            for (int j = i; j < s.length(); j++) {
                if (set.contains(s.charAt(j))) {
                    break;
                }
                stringSize++;
                set.add(s.charAt(j));
            }
            longestString = Math.max(longestString, stringSize);
        }
        return longestString;
    }
}