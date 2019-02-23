class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) {
            return true;
        } else if (s == null || t == null) {
            return false;
        } else if (s.length() != t.length()) {
            return false;
        }
        // char[] sArr = s.toCharArray(), tArr = t.toCharArray();
        // Arrays.sort(sArr);
        // Arrays.sort(tArr);
        // s = Arrays.toString(sArr);
        // t = Arrays.toString(tArr);
        // return s.equals(t);
        int[] table = new int[26];
        for(char c : s.toCharArray()){
            table[c-'a' ]++;
        }
        for(char c : t.toCharArray()){
            table[c - 'a']--;
        }
        for(int i = 0; i < table.length; i++){
            if(table[i]!=0){
                return false;
            }
        }
        return true;
    }
}