class Solution{
	public int[] productExceptSelf(int[] nums){
		int len = nums.length;
		int[] before = new int[len];
		before[0] = 1;
		for(int i = 1; i < len; i++){
			before[i] = before[i - 1]*nums[i - 1];
		}
		int right = 1;
		for(int i = len - 1; i > -1; i--){
			before[i] *= right;
			right *= nums[i];
		}
		
		return before;
	}
}