/**
 * initialize your data structure here.
 */
var MinStack = function() {
    this.stack = [];
    this.mins = []
};

/** 
 * @param {number} x
 * @return {void}
 */
MinStack.prototype.push = function(x) {
    const len = this.stack.length;
    if(len === 0 || (len > 0 && this.mins[len - 1] >= x)){
        this.stack.push(x);
        this.mins.push(x);
    }else{
        this.mins.push(this.mins[len - 1]);
        this.stack.push(x);
    }
};

/**
 * @return {void}
 */
MinStack.prototype.pop = function() {
    if(this.stack.length < 0) throw new Error('invalid pop')
    this.stack.pop()
    this.mins.pop();
    
};

/**
 * @return {number}
 */
MinStack.prototype.top = function() {
    return this.stack[this.stack.length - 1];
    
};

/**
 * @return {number}
 */
MinStack.prototype.getMin = function() {
    return this.mins[this.mins.length - 1];
    
};

/** 
 * Your MinStack object will be instantiated and called as such:
 * var obj = Object.create(MinStack).createNew()
 * obj.push(x)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */