class Solution {
    public String reverseWords(String s) {
        char[] chs = s.toCharArray();
        int start = 0, cnt = 0;
        for(int i = 0; i < chs.length; i++){
            if(chs[i] == ' '){
                swap(start, cnt, chs);
                start += cnt + 1;
                cnt = 0;
            }else{
                cnt++;
            }
        }
        swap(start, cnt, chs);
        return String.valueOf(chs);
        
    }
    public void swap(int start, int cnt, char[] chs){
        if(cnt <= 1) return;
        int end = start + cnt - 1;
        while(start < end){
            char temp = chs[start];
            chs[start] = chs[end];
            chs[end] = temp;
            start++;
            end--;
        }
    }
}