class Solution {
    public int titleToNumber(String s) {
        int res = 0;
        char[] chars = s.toCharArray();
        for(char c : chars){
            res = res*26 + c - 'A' + 1;
        }
        return res;
    }
}