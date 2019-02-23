class Solution {
    public
        ArrayList<Integer> item = new ArrayList<Integer>();
        List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int length = candidates.length;
        Arrays.sort(candidates);
        if(length==0){
            return res;
        }
        helper(candidates, target, 0);
        return res;
    }
    
    public void helper(int[] nums, int target, int index){
        for(int i =index;i<nums.length;i++){
            if(target<nums[i]){
                break;
            }
            if(target == nums[i]){
                item.add(nums[i]);
                res.add(new ArrayList<Integer>(item));
                item.remove(item.size()-1);
                break;
            }
            if(target>nums[i]){
                item.add(nums[i]);
                helper(nums, target-nums[i], i);
                item.remove(item.size()-1);
            }
        }
    }
}