class NumArray {
    public int[] nums;
    public int[] sums;
    

    public NumArray(int[] nums) {
        this.nums = nums;
        sums = new int[nums.length];
    }
    
    public int sumRange(int i, int j) {
        return getSum(j) - getSum(i) + nums[i];
       
    }
    public int getSum(int i){
        if(i == 0){
            sums[0] = nums[0];
            return sums[0];
        }
        if(sums[i] == 0){
            sums[i] = nums[i] + getSum(i - 1);
        }
        return sums[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */