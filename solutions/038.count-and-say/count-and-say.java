class Solution {
    public String countAndSay(int n) {
        if(n == 1){
            return "1";
        }else{
            return count(countAndSay(n - 1));
        }
        
        
    }
    public String count(String s){
        StringBuilder res = new StringBuilder();
        char[] c = s.toCharArray();
        int continuous = 0;
        for(int i = 0; i < c.length; i++){
            if(i == 0 || c[i] == c[i - 1]){
                continuous++;
            }else{
                res.append(continuous);
                res.append(c[i - 1]);
                continuous = 1;
            }
            if(i == c.length -1){
                res.append(continuous);
                res.append(c[i]);
            }
        }
        return res.toString();
    }
    
}