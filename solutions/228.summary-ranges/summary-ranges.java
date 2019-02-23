class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        if(nums.length < 1) return res;
        int start = 0, end = 0;
      
        for(int i = 1; i < nums.length; i++){
            if(nums[i] - nums[i-1] == 1){
                end ++;
            }else{
                res.add(start == end ? ""+nums[start] : nums[start] + "->" + nums[end]);
                start =  i;
                end = i;
            }
        }
        res.add(start == end ? ""+nums[start] : nums[start] + "->" + nums[end]);
        return res;
            
    }
        
}