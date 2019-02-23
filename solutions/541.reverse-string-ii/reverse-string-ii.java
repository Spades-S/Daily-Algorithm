class Solution {
    public String reverseStr(String s, int k) {
        int len = s.length();
        char[] chs = s.toCharArray();
        int start = 0;
        while(start < len){
            int end = start + k -1;
            if(end >= len -1) end = len -1;
            swap(chs, start, end);
            start += 2*k;
        }
        return String.valueOf(chs);
    }
    public void swap(char[] chs, int start, int end){
        while(end > start){
            char temp = chs[start];
            chs[start] = chs[end];
            chs[end] = temp;
            start++;
            end--;
        }
    }
}