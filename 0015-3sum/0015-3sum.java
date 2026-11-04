class Solution {
    // Sort first → enables two pointer + easy duplicate skipping.
    // Fix i, two pointer j and k for remaining sum = -nums[i].
    // Three duplicate checks:
    //   1. Skip duplicate i (outer loop)
    //   2. Skip duplicate j (after match)
    //   3. k handled implicitly
    // O(n²) time, O(1) space excluding output.
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return ans;
    }
}