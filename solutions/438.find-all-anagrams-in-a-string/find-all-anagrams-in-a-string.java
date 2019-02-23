class Solution {
    public List<Integer> findAnagrams(String s, String p) {
   
        
        List<Integer> res = new ArrayList<Integer>();
        int pLen = p.length();
        int[] cnts = new int[26];
        for(char c : p.toCharArray()){
            cnts[c - 'a']++;
        }
        for(int i = 0; i <= s.length() - pLen; i++){
            String substr = s.substring(i, i + pLen);
            if(substr.equals(p)) {
                res.add(i);
                continue;
            }
            if(isAnagrams(substr, Arrays.copyOf(cnts, 26))) res.add(i);
        }
        return res;
    }
    
    public boolean isAnagrams(String s, int[] cnts){
        for(char c : s.toCharArray()){
            if(cnts[c - 'a'] == 0) return false;
            else cnts[c - 'a']--;
        }
        return true;
    }
}