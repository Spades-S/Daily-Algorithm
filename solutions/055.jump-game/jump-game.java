class Solution {
    public boolean canJump(int[] nums) {
        boolean canReach = true; 
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == 0){
                canReach = false; // 这个时候可能无法达到终点
                int j = i - 1;
                while(j>=0){
                    if(nums[j]-nums[i] > i - j){
                        canReach = true;
                        break;
                    }
                    j--;
                }
                if(!canReach){
                    break;
                }
            }
        }
        return canReach;
        
    }
}