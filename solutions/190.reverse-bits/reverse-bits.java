public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for(int i = 0; i < 32; i++){
            int end = n&1;
            res <<= 1;
            res |= end;
            n >>= 1;
        }
        return res;
    }
}