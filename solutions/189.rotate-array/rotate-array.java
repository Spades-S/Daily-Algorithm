class Solution{
	public void rotate(int[] nums, int k){
		int len = nums.length;
		k %= len;
		reverse(nums, 0, len -1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, len - 1);

	}
	public void reverse(int[] nums, int start, int end){
		while(start < end){
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			end--;
			start++;
		}
	}
}