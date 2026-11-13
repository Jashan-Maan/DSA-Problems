class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longestString = 0;
        HashSet<Character> set = new HashSet<>();
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right)) && left < right) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            longestString = Math.max(longestString, right - left + 1);
        }
        return longestString;
    }
}