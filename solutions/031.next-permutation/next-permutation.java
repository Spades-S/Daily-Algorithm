class Solution {
    public void nextPermutation(int[] nums) {
        int length = nums.length;
        int breakpoint = -1;
        for(int i = length -1;i>0;i--){
            if(nums[i]>nums[i-1]){
                breakpoint = i;
                break;
            }
        }

        if(breakpoint == -1){
            Arrays.sort(nums);
        }else{
            for(int i =length-1;i>breakpoint-1;i--){
                if(nums[i]>nums[breakpoint-1]){
                    int temp = nums[breakpoint -1];
                    nums[breakpoint-1]=nums[i];
                    nums[i]=temp;
                    break;
                }
            }
            if(breakpoint < length-1){
                Arrays.sort(nums,breakpoint,length);
            }
        } 
        
    }
}