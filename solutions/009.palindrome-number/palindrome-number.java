class Solution {
    public boolean isPalindrome(int x) {
        if(x<0 ||(x%10==0&&x!=0)){
            return false;
        }else{
            int temp = 0;
            while(temp < x){
                temp = temp*10 + x%10;
                x = x/10;
            }
            if(x==temp || temp/10 ==x ){
                return true;
            }else{
                return false;
            }
        }
        
    }
}