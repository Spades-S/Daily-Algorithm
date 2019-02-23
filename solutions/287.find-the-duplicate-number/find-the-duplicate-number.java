class Solution {
    public int findDuplicate(int[] nums) {
			int fast = nums[nums[0]], slow = nums[0];
			while(fast != slow){
				fast = nums[nums[fast]];
				slow = nums[slow];
			}
			slow = 0;
			while(fast != slow){
				slow = nums[slow];
				fast = nums[fast];
			}
			return slow;
    }
}