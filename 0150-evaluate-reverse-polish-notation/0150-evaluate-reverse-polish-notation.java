class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*")
                    || tokens[i].equals("/")) {
                int second = Integer.parseInt(stack.pop());
                int first = Integer.parseInt(stack.pop());
                int ans = perform(first, second, tokens[i]);
                System.out.println(ans);
                stack.push(Integer.toString(ans));
            } else {
                stack.push(tokens[i]);
            }
        }
        return Integer.parseInt(stack.peek());
    }

    private int perform(int i, int j, String op) {
        if (op.equals("+")) {
            return i + j;
        } else if (op.equals("*")) {
            return i * j;
        } else if (op.equals("-")) {
            return i - j;
        } else {
            return i / j;
        }
    }
}