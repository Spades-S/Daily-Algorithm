class Solution {
    public String reverseString(String s) {
        char[] chars = s.toCharArray();
        int start = 0, end = chars.length -1;
        while(start < end){
            char temp = chars[end];
            chars[end] = chars[start];
            chars[start] = temp;
            start++;
            end--;
        }
        return new String(chars);
    }
}