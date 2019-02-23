class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i - 1 - k]);  // 维护了定长HashSet
            if(!set.add(nums[i])) return true;
        }
        return false;
    }
}