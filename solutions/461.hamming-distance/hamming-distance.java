class Solution {
    public int hammingDistance(int x, int y) {
        int hamming = x ^ y;
        int res = 0;
        for(int i = 0; i < 31; i++){
            if((hamming & 1) == 1){
                res++;
            }
            hamming >>= 1;
        }
        return res;
    }
}