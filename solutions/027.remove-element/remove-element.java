class Solution {
    public int removeElement(int[] nums, int val) {
        int result=0,dStart=-1;
        Arrays.sort(nums);
        for(int i = 0;i<nums.length;i++){
            if(nums[i]!= val){
                result++;
            }else if(dStart == -1){
                dStart = i;
            }
        }
        int dLength = nums.length -result;
        if(dLength>0){
            for(int i = 0;i<dLength;i++){
                if(nums.length-1-i>dStart+dLength-1){
                    nums[dStart+i] = nums[nums.length-1-i];
                }else{
                    break;    
                }
           
            }
        }

        return result;
    }
}