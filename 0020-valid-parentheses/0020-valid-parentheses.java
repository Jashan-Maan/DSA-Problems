class Solution {
    // Push opening brackets, pop on matching closing bracket.
    // Mismatch or empty stack on close → push (will fail at end).
    // Cleaner: HashMap maps closing→opening for O(1) lookup.
    // return stack.isEmpty() — unmatched openers fail here.
    // O(n) time, O(n) space.
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (isValid(stack, ch)) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }

    private boolean isValid(Stack<Character> stack, char ch) {
        return !stack.isEmpty()
                && ((stack.peek() == '[' && ch == ']') || (stack.peek() == '{' && ch == '}')
                        || (stack.peek() == '(' && ch == ')'));
    }
}