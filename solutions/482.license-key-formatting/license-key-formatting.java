class Solution {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder res = new StringBuilder();
        int cnt = 0;
        S = S.toUpperCase();
        for(int i = 0; i < S.length(); i++){
            char c = S.charAt(S.length() - 1 - i);
            if(c == '-') continue;
            
            if(cnt != 0 && cnt % K == 0){
                res.append('-');
            }
            res.append(c);
            cnt++;
        }
        return res.reverse().toString();
        
    }
}
