class Solution {
    public boolean detectCapitalUse(String word) {
        if(word.length() <= 1) return true;
        boolean res = true;
        boolean isUpperCase = true;
        if(word.charAt(0) - 'a' >= 0 || (word.charAt(0) - 'a' < 0 && word.charAt(1) - 'a' >= 0)){
            isUpperCase = false;
        }
        for(int i = 1; i < word.length(); i++){
            char c = word.charAt(i);
            if((isUpperCase && (c - 'a' >= 0)) || (!isUpperCase && (c - 'a' < 0))){
                res = false;
            }
        }
        return res;
    }
}