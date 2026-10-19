class Solution {
    // For each num, check if complement (target-num) already seen.
    // Store num→index in map for future lookups.
    // else prevents same element being used twice.
    // Guaranteed one solution exists → return ansArr never reached.
    // O(n) time, O(n) space.
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                ans[0] = map.get(target - nums[i]);
                ans[1] = i;
            }
            map.put(nums[i], i);
        }
        return ans;
    }
}