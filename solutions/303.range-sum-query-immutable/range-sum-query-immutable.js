/**
 * @param {number[]} nums
 */
var NumArray = function(nums) {
    this.sums = new Array(nums.length);
    for(let i = 0 ; i < nums.length; i++){
        if(i === 0) this.sums[i] = nums[i];
        else{
            this.sums[i] = this.sums[i - 1] + nums[i];
        }
    }
    this.sums.unshift(0);
    
};

/** 
 * @param {number} i 
 * @param {number} j
 * @return {number}
 */
NumArray.prototype.sumRange = function(i, j) {
    return this.sums[j + 1] - this.sums[i] ;
    
};

/** 
 * Your NumArray object will be instantiated and called as such:
 * var obj = Object.create(NumArray).createNew(nums)
 * var param_1 = obj.sumRange(i,j)
 */