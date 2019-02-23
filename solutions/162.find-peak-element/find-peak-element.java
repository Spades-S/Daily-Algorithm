class Solution {
    public int findPeakElement(int[] nums) {
        int L = 0, R = nums.length - 1;
        while(L < R){
            int mid = L + (R - L)/2;
            if(nums[mid] > nums[mid + 1]){
                R = mid;
            }else{
                L = mid + 1;
            }
        }
        return R;
    }
}