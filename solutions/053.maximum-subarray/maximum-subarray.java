class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0], result = nums[0];
        for(int i = 1; i < nums.length; i++){
            sum = sum > 0 ? sum + nums[i] : nums[i];
            result = sum > result ? sum : result;
        }
        return result;
    }
}