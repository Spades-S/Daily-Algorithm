class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if(m<=0){
            return 0;
        }
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(m-1,n-1,grid,dp);
    }
    
    public int helper(int i, int j, int[][] grid,int[][] dp){
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(i==0 && j==0){
            dp[i][j] = grid[0][0];
        }else{
            if(i==0){
                dp[i][j] = helper(i,j-1,grid,dp)+grid[i][j];
            }else if(j==0){
                dp[i][j] = helper(i-1,j,grid,dp)+grid[i][j];
            }else{
                
        dp[i][j] = Math.min(helper(i,j-1,grid,dp), helper(i-1,j,grid,dp))+grid[i][j];
            }
        }
        return dp[i][j];
        
    }
}