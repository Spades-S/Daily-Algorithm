class Solution {
    public int findMin(int[] nums) {
        int length = nums.length;
        if(length == 1){
            return nums[0];
        }
        if(nums[0] >= nums[length -1]){
            int L = 0, R = length - 1;
            while(L < R - 1){
                int mid = L + (R - L)/2;
                if(nums[mid] > nums[R]){ 
                    L = mid;
                }else if(nums[mid] < nums[R]){
                    R = mid;
                }else{
                    R--;
                }
            }
            return nums[R];
        }
        return nums[0];
    }
}