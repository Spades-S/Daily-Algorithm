class Solution {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int start = 0, end = chars.length - 1;
        while(start < end){
            if(!isVowels(chars[start])){
                start++;
                continue;
            }
            if(!isVowels(chars[end])){
                end--;
                continue;
            }
            char temp = chars[end];
            chars[end] = chars[start];
            chars[start] = temp;
            end--;
            start++;
        }
        return new String(chars);
        
    }
    public boolean isVowels(char c){
        c = (""+c).toLowerCase().charAt(0);
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return true;
        return false;
    }
}