class Solution {
    public int strStr(String haystack, String needle) {
        int needleLen = needle.length(), haystackLen = haystack.length();
        if(needleLen == 0){
            return 0;
        }
        for(int i = 0; i <= haystackLen - needleLen; i++){
            if(haystack.substring(i, i + needleLen).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}