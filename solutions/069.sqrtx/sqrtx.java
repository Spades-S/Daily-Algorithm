class Solution {
    public int mySqrt(int x) {
        if(x == 0){
            return 0;
        }else if(x >= 1 && x < 4){
            return 1;
        }else if(x >=4 && x < 9){
            return 2;
        }
        for(int i = 3; i <= x/3; i++){
            if(x / i == i) {
                return i;
            }
            if(x / i > i && x /(i+1) < i+1){
                return i;
            }
        }
        return 0;
    }
}