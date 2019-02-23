class Solution {
    public
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int length = candidates.length;
        if(length==0){
            return res;
        }
        Arrays.sort(candidates);
        helper(candidates,target,0);
        return res;
        
    }
    public void helper(int[] nums, int target, int index){
        for(int i = index;i<nums.length;i++){
            if(i>0 && i>index && nums[i-1]==nums[i]){
                continue;
            }
            if(target<nums[i]){
                break;
            }
            if(target==nums[i]){
                item.add(nums[i]);
                res.add(new ArrayList<Integer>(item));
                item.remove(item.size()-1);
                break;
            }
            if(target>nums[i]){
                item.add(nums[i]);
                if(i<nums.length-1){
                   helper(nums,target-nums[i],i+1); 
                }
                item.remove(item.size()-1);
            }
      
        }
    }
}