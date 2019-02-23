class Solution{
  public int[] twoSum(int[] nums, int target){
    int length = nums.length;
    Map<Integer,Integer> save = new HashMap<>();
    int[] result = null;
    for(int i =0;i<length;i++){
      int another = target - nums[i];
      if(save.containsKey(another)){
        	result = new int[]{save.get(another),i};
        	break;
		}
      save.put(nums[i],i);
    }
     return result;
  }
}