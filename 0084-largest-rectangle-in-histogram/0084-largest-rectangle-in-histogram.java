class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] nSL = nextSmallestLeft(heights);
        int[] nSR = nextSmallestRight(heights);

        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            int width = nSR[i] - nSL[i] - 1;
            int area = width * heights[i];
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    private int[] nextSmallestLeft(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[heights.length];

        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            res[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(i);
        }
        return res;
    }

    private int[] nextSmallestRight(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[heights.length];

        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            res[i] = stack.isEmpty() ? heights.length : stack.peek();

            stack.push(i);
        }
        return res;
    }
}
