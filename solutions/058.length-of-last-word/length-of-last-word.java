class Solution {
    public int lengthOfLastWord(String s) {
        int len = 0;
        char[] c = s.toCharArray();
        boolean start = false;
        for(int i = c.length - 1; i > -1; i--){
            if(c[i] != ' '){
                start = true;
                len++;
            }
            if(c[i] == ' ' && start){
                break;
            }
        }
        return len;
    }
}