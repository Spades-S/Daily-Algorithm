class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        int res = 0;
        int[] sums = new int[len + 1];
        sums[0] = 0;
        for(int i = 1; i <= len; i++){
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for(int i = 0; i < len; i++){
            int right = helper(sums, i + 1, len, sums[i] + s);
            if(right > len) break;
            res = res == 0 ?right - i : right - i > res ? res : right -i; 
        }
        return res;
    }
    
    public int helper(int[] sums,  int left, int right, int target){
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(sums[mid] >= target) {
               right = mid - 1; 
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}