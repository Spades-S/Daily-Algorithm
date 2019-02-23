class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        int[] temp = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(i == 0){
              temp[0] = nums[0];  
            }else if(i == 1){
               temp[1] = Math.max(nums[0], nums[1]); 
            }else{
                temp[i] = Math.max(temp[i-2]+nums[i], temp[i - 1]);
            } 
        }
        return temp[nums.length - 1];
    }
}