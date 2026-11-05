class Solution {
    // Two pointer: water = min(height[i], height[j]) * (j-i).
    // Always move the shorter wall — moving taller wall can only decrease water.
    // Proof: shorter wall is the bottleneck, moving it is the only way to improve.
    // O(n) time, O(1) space.
    public int maxArea(int[] heights) {
        int n = heights.length;
        int left = 0, right = n - 1;

        int maxWater = 0;
        while (left < right) {
            int distance = right - left;
            int waterLevel = Math.min(heights[left], heights[right]);
            int totalWater = waterLevel * distance;
            maxWater = Math.max(totalWater, maxWater);
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxWater;
    }
}