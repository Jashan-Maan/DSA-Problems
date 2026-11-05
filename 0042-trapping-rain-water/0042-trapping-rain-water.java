class Solution {
    public int trap(int[] height) {
        // Two pointer O(1) space optimization of DP approach.
        // Key insight: process the smaller side first — it's the bottleneck.
        // If leftMax < rightMax → left side limits water → process left.
        // Move pointer FIRST, then update max, then add water.
        // Eliminates two O(n) arrays from DP solution.

        if (height.length == 0)
            return 0;
        int n = height.length;
        int leftMax = height[0], rightMax = height[n - 1];

        int left = 0, right = n - 1;

        int trappedWater = 0;
        while (left <= right) {
            if (leftMax < rightMax) {
                leftMax = Math.max(leftMax, height[left]);
                trappedWater += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                trappedWater += rightMax - height[right];
                right--;
            }
        }
        return trappedWater;
    }
}