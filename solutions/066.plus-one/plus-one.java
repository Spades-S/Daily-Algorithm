class Solution {
    public int[] plusOne(int[] digits) {
        int length = digits.length, remain = 1;
        for(int i = length-1; i>=0; i--){
            remain = (digits[i]+1)/10;
            digits[i]=(digits[i]+1)%10;
            if(remain==0){
                break;
            }
        }
        
        if(remain>0){
            int[] res = new int[length+1];
            res[0] = remain;
            for(int i = 1; i< length+1;i++){
                res[i] = digits[i-1];
            }
            return res;
        }
        
        return digits;
    }
}