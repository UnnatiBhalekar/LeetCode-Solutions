class MinStack {
    Stack<Long> stack;
    long min = Integer.MAX_VALUE;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int value) {
        if(stack.isEmpty()){
            min = value;
            stack.push((long) value);
        }
        else if(value < min){
            long new_val = 2L * value - min;
            min = value;
            stack.push((long) new_val);
        }
        else{
            stack.push((long) value);
        }
    }
    
    public void pop() {
        if(stack.isEmpty()){
            return;
        }
        long top = stack.peek();
        stack.pop();
        if(top < min){
            long prev_min = 2L * min - top;
            min = prev_min;
        }
    }
    
    public int top() {
        if(stack.isEmpty()){
            return -1;
        }
        long top = stack.peek();
        if(top < min){
            return (int) min;
        }
        else{
            return (int) top;
        }

    }
    
    public int getMin() {
        if(!stack.isEmpty()){
            return (int) min;
        }
        else{
            return -1;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */