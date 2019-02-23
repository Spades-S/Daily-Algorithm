class Solution {
    public String convertToTitle(int n) {
        String res = "";
        while(n != 0){
            n = n -1;
            res = (char)(n % 26 + 'A') + res;
            n = n /26;
        }
        return res;
    }
}