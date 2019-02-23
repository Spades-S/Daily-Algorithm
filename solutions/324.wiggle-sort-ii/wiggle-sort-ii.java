class Solution {
    public void wiggleSort(int[] nums) {
        int length = nums.length;
        if(length<=1){
            return;
        }
        int[] result = new int[length];
        Arrays.sort(nums);
        for(int i=0;i<length;i++){
            if(i%2==0){
                result[i] = nums[(length-1)/2 - i/2];
            }else{
                result[i] = nums[length-1 - i/2];
            }
        }
        for(int i = 0; i<length;i++){
            nums[i] = result[i];
        }
    }
}