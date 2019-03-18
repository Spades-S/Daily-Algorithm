/**
 * Initialize your data structure here.
 */
function ListNode(val){
    this.val = val;
    this.next = null;
}


var MyLinkedList = function() {
    this.stack = [];
};

/**
 * Get the value of the index-th node in the linked list. If the index is invalid, return -1. 
 * @param {number} index
 * @return {number}
 */
MyLinkedList.prototype.get = function(index) {
    if(index < 0 || index >= this.stack.length){
        return -1;
    }
    return this.stack[index].val;
};

/**
 * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. 
 * @param {number} val
 * @return {void}
 */
MyLinkedList.prototype.addAtHead = function(val) {
    const node = new ListNode(val);
    if(this.stack.length !== 0){
        node.next = this.stack[0];
    }
    this.stack.unshift(node);
};

/**
 * Append a node of value val to the last element of the linked list. 
 * @param {number} val
 * @return {void}
 */
MyLinkedList.prototype.addAtTail = function(val) {
    const node = new ListNode(val);
    const len = this.stack.length;
    if(len !== 0){
        this.stack[len - 1].next = node;
    }
    this.stack.push(node);
};

/**
 * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. 
 * @param {number} index 
 * @param {number} val
 * @return {void}
 */
MyLinkedList.prototype.addAtIndex = function(index, val) {
    const len = this.stack.length;
    if(index > this.stack.length) return;
    const node = new ListNode(val);
    this.stack.splice(index, 0, node);
};

/**
 * Delete the index-th node in the linked list, if the index is valid. 
 * @param {number} index
 * @return {void}
 */
MyLinkedList.prototype.deleteAtIndex = function(index) {
    if(index > 0 && index < this.stack.length){
        this.stack.splice(index, 1);
    }
};

/** 
 * Your MyLinkedList object will be instantiated and called as such:
 * var obj = Object.create(MyLinkedList).createNew()
 * var param_1 = obj.get(index)
 * obj.addAtHead(val)
 * obj.addAtTail(val)
 * obj.addAtIndex(index,val)
 * obj.deleteAtIndex(index)
 */