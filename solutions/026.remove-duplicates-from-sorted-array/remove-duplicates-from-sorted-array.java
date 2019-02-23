class Solution {
    public int removeDuplicates(int[] nums) {
        int counter = 0;
        for(int i=0;i<nums.length;i++){
            if(i==0 || nums[i]!=nums[counter-1]){
                nums[counter]=nums[i];
                counter++;
            }
        }
        return counter;
    }
}