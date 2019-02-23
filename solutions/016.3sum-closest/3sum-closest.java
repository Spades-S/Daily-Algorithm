class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int minDiff = 0, result=0,length = nums.length;
        int[] temp = null;
        Arrays.sort(nums);
        temp = twoSumClosest(nums,0,target);
        minDiff = temp[0];
        result = temp[1];
        for(int i = 1;i<length-2;i++){
            if(nums[i]==nums[i-1]) continue;
            temp = twoSumClosest(nums,i,target);
            if(minDiff>temp[0]){
                result = temp[1];
                minDiff = temp[0];
            }
        }
        return result;
    }
    private int[] twoSumClosest(int[] nums, int i, int target){
        int start = i+1, end= nums.length-1,minDiff = 0,sum = 0;
        sum = nums[i] + nums[start] + nums[end];
        minDiff = Math.abs(target - sum);
        while(start < end){
            int diff = target - nums[i] - nums[start] - nums[end];
            if(diff > 0){
                if(minDiff>diff){
                    minDiff = diff;
                    sum = nums[i] + nums[start] + nums[end];
                }
                start++;
            }else{
                if(minDiff> 0 - diff){
                    minDiff = 0 - diff;
                    sum = nums[i] + nums[start] + nums[end];
                }
                end--;
            }
        }
        int[] result = {minDiff,sum};
        return result;
    }
}