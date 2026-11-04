class Solution {
    public boolean isPalindrome(String s) {
        // Two pointer from both ends, skip non-alphanumeric in place.
        // Character.isLetterOrDigit() + toLowerCase() avoids new string allocation.
        // O(n) time, O(1) space. replaceAll() approach is O(n) space — avoid.
        int left = 0, right = s.length() - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}