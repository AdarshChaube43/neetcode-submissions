class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    public MinStack() {
        
    }
    
    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty()) this.minStack.push(val);
        else{
        val = Math.min(val,this.minStack.peek());
        this.minStack.push(val);}


    }
    
    public void pop() {
        this.minStack.pop();
        this.stack.pop();
    }
    
    public int top() {
        return this.stack.peek();
    }
    
    public int getMin() {
        return this.minStack.peek();
    }
}
