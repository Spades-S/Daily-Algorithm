class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num : nums){
           map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int len = nums.length;
        ArrayList<Integer>[] temp = new ArrayList[len + 1];
        for(int num : map.keySet()){
            if(temp[map.get(num)] == null){
                temp[map.get(num)] = new ArrayList<Integer>();
            }
            temp[map.get(num)].add(num);
        }
        int count = 0;
        for(int i = len; i > -1 ; i--){
            if(temp[i]!=null){
                res.addAll(temp[i]);
                count ++;
            }
            if(res.size() >= k){
                break;
            }
        }
        return res;
    }
}