class Solution {
    public void moveZeroes(int[] nums) {
        int cnt = 0, len = nums.length;
        for(int i = 0; i < len; i++){
            if(nums[i] != 0){
                nums[cnt] = nums[i];
                cnt++;
            }
        }
        for(int i = 0; i < len - cnt; i++){
            nums[len - 1 - i] = 0;
        }
    }
}