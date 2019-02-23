class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        for(int num : nums){
            int index = Math.abs(num) - 1;
            if(nums[index] > 0) nums[index] = -nums[index];
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0) res.add(i+1);
        }
        return res;
    }
}