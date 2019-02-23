class Solution {
    public boolean search(int[] nums, int target) {
        int length = nums.length;
        if(length == 0){
            return false;
        }
        int L = 0, R = length - 1;
        while(L <= R){
            int M = (R - L)/2 + L;
            if(nums[M] == target){
                return true;
            }else if(nums[M] > nums[R]){
                if(nums[L]<=target && nums[M] >= target){
                    R = M - 1;
                }else{
                   L = M + 1; 
                }                
            }else if(nums[M] < nums[R]){
                if(nums[M]<=target && nums[R] >= target){
                    L = M + 1;
                }else{
                    R = M - 1;
                }
            }else{
                R--;
            }
        }

        return false;
    }
}