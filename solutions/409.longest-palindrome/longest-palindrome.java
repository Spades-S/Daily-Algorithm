class Solution {
    public int longestPalindrome(String s) {
        int[] cnts = new int[52];
        for(char c : s.toCharArray()){
            if(c > 'Z'){
                cnts[c - 'a' + 26]++;
                continue;
            }
            cnts[c - 'A']++;
            
        }
        int res = 0;
        for(int cnt : cnts){
            res += (cnt / 2) * 2;
        }
        if(s.length()> res){
            res += 1;
        }
        return res;
    }
}