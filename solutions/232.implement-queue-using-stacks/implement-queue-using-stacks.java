class MyQueue {
    Stack<Integer> stack;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        int len = stack.size();
        int[] temp = new int[len];
        for(int i = len - 1; i> -1; i--){
            temp[i] = stack.pop();
        }
        stack.push(x);
        for(int num : temp){
            stack.push(num);
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        return stack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */