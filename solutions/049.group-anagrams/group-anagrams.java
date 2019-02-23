class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        int len = strs.length;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i < len; i++){
            char[] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String sorted = String.valueOf(temp);
            if(map.containsKey(sorted)){
                int index = map.get(sorted);
                res.get(index).add(strs[i]);
            }else{
                List<String> list = new ArrayList<String>();
                list.add(strs[i]);
                map.put(sorted, res.size());
                res.add(list);
            }
        }
        return res;
    }
}