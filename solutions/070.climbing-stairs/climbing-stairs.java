class Solution {
    public int climbStairs(int n) {
        int[] temp = new int[n];
        return helper(n, temp);
    }
    
    public int helper(int n, int[] temp){
        if(temp[n - 1] != 0){
            return temp[n - 1];
        }
        if(n == 1){
            temp[0] = 1;
            return 1;
        }
        if(n == 2){
            temp[1] = 2;
            return 2;
        }
        temp[n - 1] = helper(n - 1, temp) + helper(n - 2, temp);
        return temp[n - 1];
    }
}