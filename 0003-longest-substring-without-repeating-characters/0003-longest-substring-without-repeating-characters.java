class Solution {
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