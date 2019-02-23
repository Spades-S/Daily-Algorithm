class Solution {
    public String[] findRelativeRanks(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        Arrays.sort(nums);
        String[] res = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            switch(i){
                case 0:
                    res[map.get(nums[nums.length - 1 - i])] = "Gold Medal";
                    break;
                case 1:
                    res[map.get(nums[nums.length - 1 -i])] = "Silver Medal";
                    break;
                case 2:
                    res[map.get(nums[nums.length - 1 -i])] = "Bronze Medal";
                    break;
                default:
                     res[map.get(nums[nums.length - 1 -i])] = String.valueOf(i + 1);
            }
        }
        return res;
        
    }
}