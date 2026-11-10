class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*")
                    || tokens[i].equals("/")) {

                int second = (stack.pop());
                int first = (stack.pop());
                int ans = perform(first, second, tokens[i]);
                stack.push(ans);

            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.peek();
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