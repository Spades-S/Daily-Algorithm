class Solution {
    public boolean checkPerfectNumber(int num) {
        if(num <=0) return false;
        int sum =0;
        for(int i = 1; i <= Math.sqrt(num); i++){
            if(num % i == 0){
                if(i != num){
                    sum += i;
                }
                if( num/i != num){
                    sum += num / i;
                }
            }
        }
        if(sum == num){
            return true;
        }
        return false;
    }
}