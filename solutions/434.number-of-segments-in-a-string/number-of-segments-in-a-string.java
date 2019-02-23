class Solution {
    public int countSegments(String s) {
        String[] strs = s.split(" ");
        int res = 0;
        for(String str : strs){
            if(!str.equals("")){
                res++;
            }
        }
        return res;
    }
}