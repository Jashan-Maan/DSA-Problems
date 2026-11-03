class Solution {
    // Two pointer exploits sorted property.
    // Sum too small → move left pointer right (increase sum).
    // Sum too large → move right pointer left (decrease sum).
    // Guaranteed solution exists → return [-1,-1] never actually reached.
    // O(n) time, O(1) space. Beats HashMap O(n) space from LC 1.
    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[] { left + 1, right + 1 };
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[2];
    }
}