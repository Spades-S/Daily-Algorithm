class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        for(int num : nums){
					int index = Math.abs(num) - 1; // 
					if(nums[index] < 0){
						res.add(index + 1);
					} 
					else{
						nums[index] = -nums[index];
					}
        }
        return res;
    }
}