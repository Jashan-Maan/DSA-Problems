class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
        Stack<int[]> stack = new Stack<>();
        int ans[] = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek()[0] <= temp[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                ans[i] = 0;
            } else {
                ans[i] = stack.peek()[1] - i;
            }

            stack.push(new int[] { temp[i], i });
        }
        return ans;
    }
}
