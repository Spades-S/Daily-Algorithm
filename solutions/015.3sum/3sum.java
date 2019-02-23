class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        if(length<3){
            return result;
        }
        List<Integer> beforeItem = new ArrayList<Integer>();
        Arrays.sort(nums);
        
        for(int i = 0;i<length-2;i++){
            if(i>0 && nums[i-1]==nums[i]) continue;
            result.addAll(twoSum(nums,i,length));
        }
        return result;
    }
    private List<List<Integer>> twoSum(int[] nums,int i,int length){
        List<List<Integer>> res = new ArrayList<>();
        int target = 0 - nums[i], start=i+1, end=nums.length-1;
        while(start<end){
            if(nums[start] + nums[end] == target){
                List<Integer> item = new ArrayList<Integer>();
                item.add(nums[i]);
                item.add(nums[start]);
                item.add(nums[end]);
                res.add(item);
                do{
                    start ++;
                }while(nums[start]==nums[start-1] && start<length-1);
                do{
                    end --;
                }while(nums[end] == nums[end+1] && end > start);
            }else if(nums[start]+nums[end]>target){
                end --;
            }else{
                start++;
            }
        }
        return res;
        
        
    }
}