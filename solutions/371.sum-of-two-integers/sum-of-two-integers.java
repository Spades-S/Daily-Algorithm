class Solution {
    public int getSum(int a, int b) {
        int carry = (a & b) << 1;
        int res = a ^ b;
        while(carry != 0){
            a = carry;
            b = res;
            carry = (a & b) << 1;
            res = a ^ b;
        }
        return res;
    }
}