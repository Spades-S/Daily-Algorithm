class Solution {
    public int findPairs(int[] nums, int k) {
        if(k < 0) return 0;
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(int key : map.keySet()){
            if(k == 0){
                if(map.get(key) >= 2){
                   res++; 
                }
                
            }else if(map.containsKey(key - k)){
                res++;
            }
        }
        return res;
    }
}