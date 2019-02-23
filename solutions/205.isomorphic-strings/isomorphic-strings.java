class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        for(int i = 0; i < s.length(); i++){
            char sChar = s.charAt(i), tChar = t.charAt(i);
            if(map.containsKey(sChar)){
                if(tChar != map.get(sChar)) return false;
            }else{
                if(map.containsValue(tChar)) return false;
                map.put(sChar, tChar);
            }
        }
        return true;
    }
}