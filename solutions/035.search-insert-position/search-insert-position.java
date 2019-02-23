class Solution {
    public int searchInsert(int[] nums, int target) {
        int length = nums.length,result=0;
        if(length<=0){
            return 0;
        }
        for(int i = 0;i<length;i++){
            if(nums[i]>=target){
                result = i;
                break;
            }
            if(i == length-1){
                result = length;
            }
        }
        return result;
    }
}