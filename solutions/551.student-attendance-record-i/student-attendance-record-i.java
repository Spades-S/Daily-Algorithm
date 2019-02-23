class Solution {
    public boolean checkRecord(String s) {
        char[] chs = s.toCharArray();
        int absentCnt = 0;
        for(int i = 0; i < s.length(); i++){
            if(chs[i] == 'A'){
                absentCnt++;
                if(absentCnt > 1){
                    return false;
                }
            }
            if(i > 1 && chs[i] == 'L' && chs[i - 1] == 'L' && chs[i - 2] == 'L'){
                return false;
            }
        }
        return true;
    }
}