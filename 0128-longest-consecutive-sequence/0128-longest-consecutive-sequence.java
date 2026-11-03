class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }

        // Brute force :- Sort
        Arrays.sort(nums);
        int ans = 1;
        int longest = 1;
        for (int i = 1; i < nums.length; i++) {
            int prev = nums[i - 1];
            int curr = nums[i];
            if (prev + 1 == curr) {
                longest++;
            } else if (prev == curr) {
                continue;
            } else {
                longest = 1;
            }
            ans = Math.max(longest, ans);
        }

        return ans;
    }
}