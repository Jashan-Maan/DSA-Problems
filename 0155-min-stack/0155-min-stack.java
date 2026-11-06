class MinStack {
    Stack<Integer> stack;
    ArrayList<Integer> list;
    int idx;

    public MinStack() {
        stack = new Stack<>();
        list = new ArrayList<>();
        idx = 0;
    }

    public void push(int val) {
        stack.push(val);
        int minVal = Integer.MAX_VALUE;
        if (idx == 0) {
            minVal = Math.min(val, minVal);
        } else {
            minVal = Math.min(val, list.get(idx - 1));
        }
        list.add(minVal);
        idx++;
    }

    public void pop() {
        stack.pop();
        list.remove(idx - 1);
        idx--;
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return list.get(idx - 1);
    }
}
