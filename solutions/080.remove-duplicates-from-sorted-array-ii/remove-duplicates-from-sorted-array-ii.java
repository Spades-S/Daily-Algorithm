class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(len <=2 ) return len;
        int counter = 2;
        for(int i = 2; i < len; i++){
            if(nums[counter - 2] != nums[i]){
                nums[counter] = nums[i];
                counter++;
            }
        }
        return counter;
    }
}