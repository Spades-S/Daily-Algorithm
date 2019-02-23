class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            result.addAll(threeSum(nums,i,target));
        }
        return result;
    }
    private List<List<Integer>> threeSum(int[] nums,int i, int target){
        List<List<Integer>> result = new ArrayList<>();
        for(int j = i+1;j<nums.length-2;j++){
            if(j>i+1 && nums[j]==nums[j-1]) continue;
            result.addAll(twoSum(nums, i, j, target));
        }
        return result;
    }
    private List<List<Integer>> twoSum(int[] nums, int i, int j, int target){
        int start = j + 1, end = nums.length - 1;
        List<List<Integer>> result = new ArrayList<>();
        while(start<end){
            if(nums[i] + nums[j] + nums[start] + nums[end] == target){
                List<Integer> item = Arrays.asList(nums[i], nums[j], nums[start], nums[end]);
                result.add(item);
                 do{
                    end--;
                }while(nums[end]==nums[end+1] && end > start);
                 do{
                    start++;
                }while(nums[start]==nums[start-1] && start< nums.length-1);
            }else if(nums[i] + nums[j] + nums[start] + nums[end] > target){
                do{
                    end--;
                }while(nums[end]==nums[end+1] && end > start);
            }else{
                do{
                    start++;
                }while(nums[start]==nums[start-1] && start< nums.length-1);
            }
        }
        return result;
    } 
}