class Solution {
    public String convertToBase7(int num) {
        if(num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        boolean isPositive = true;
        if(num < 0){
            isPositive = false;
            num = -num;
        }
        while(num > 0){
            sb.append(num % 7);
            num /= 7;
        }
        if(!isPositive){
            sb.append('-');
        }
        return sb.reverse().toString();
    }
}