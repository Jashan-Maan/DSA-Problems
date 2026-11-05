class Solution {
    public int trap(int[] height) {
        // Two pointer O(1) space optimization of DP approach.
        // Key insight: process the smaller side first — it's the bottleneck.
        // If leftMax < rightMax → left side limits water → process left.
        // Move pointer FIRST, then update max, then add water.
        // Eliminates two O(n) arrays from DP solution.

        int n = height.length;
        int leftMax[] = new int[n];
        int rightMax[] = new int[n];

        // Finding left max heights
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        }

        // Finding Right Max heights
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }

        int trappedWater = 0;
        for (int i = 0; i < n; i++) {
            int water = Math.min(leftMax[i], rightMax[i]) - height[i];
            if (water > 0) {
                trappedWater += water;
            }
        }
        return trappedWater;
    }
}