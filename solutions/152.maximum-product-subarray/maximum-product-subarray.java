class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        int res = nums[0];
        int arrMax = nums[0];
        int arrMin = nums[0];
        for(int i = 1; i < n; i++){
            int larger = 0, smaller = 0;
            if(arrMax*nums[i] > arrMin*nums[i]){
                larger = arrMax*nums[i];
                smaller = arrMin*nums[i];
            }else{
                smaller = arrMax*nums[i];
                larger = arrMin*nums[i];                
            }
            arrMax = larger > nums[i] ? larger : nums[i];
            arrMin = smaller < nums[i] ? smaller : nums[i];
            // arrMax[i] = Math.max(larger, nums[i]);
            // arrMin[i] = Math.min(smaller, nums[i]);
            if(res < arrMax) res = arrMax;
        }
        return res;
    }
}