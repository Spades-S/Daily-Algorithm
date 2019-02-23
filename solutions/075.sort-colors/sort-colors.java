class Solution {
    public void sortColors(int[] nums) {
        // 插入排序
        int length = nums.length;
        for(int i = 1; i< length; i++){
            int temp = nums[i];
            int j = i-1;
            for(;j>=0 && nums[j]>temp;j--){
                nums[j+1] = nums[j];
            }
            nums[j+1] = temp;
        }
    }
}