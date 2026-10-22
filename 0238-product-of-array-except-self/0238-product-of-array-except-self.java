class Solution {
    // Prefix pass: res[i] = product of all elements LEFT of i.
    // Suffix pass: multiply res[i] by product of all elements RIGHT of i.
    // Running suffix variable avoids O(n) extra space.
    // Start both prefix and suffix at 1 (multiplicative identity).
    // O(n) time, O(1) space. No division used.
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        // Calculate the prefix product array in resultant array.
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        // Calculate the suffix product  in the resultant array.
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] = suffix * res[i];
            suffix = suffix * nums[i];
        }
        return res;
    }
}