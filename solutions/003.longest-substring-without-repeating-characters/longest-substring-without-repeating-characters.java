class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int[] toDiscardNum = new int[128];
        for(int i =0 ,j=0;j<s.length();j++){
            i = Math.max(toDiscardNum[s.charAt(j)],i);
            result = Math.max(result,j-i+1);
            toDiscardNum[s.charAt(j)] = j+1;
        
        }
        return result;
    
    }
}