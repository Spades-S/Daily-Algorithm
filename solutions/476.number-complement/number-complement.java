class Solution {
    public int findComplement(int num) {
        if(num == 0) return 1;
        int res = 0;
        for(int i = 0; i < 32 && num != 0; i++){
            int bit = num & 1;
            bit ^= 1;
            bit =  bit << i;
            res |= bit;
            num >>>= 1;
        }
        return res;
    }
}