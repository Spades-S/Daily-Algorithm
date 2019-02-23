class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if(m<1){
            return 0;
        }
        int n = obstacleGrid[0].length;
        int[][] result = new int[m][n];
        for(int i = m-1; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){
                 if(obstacleGrid[i][j]==1){
                        result[i][j] = 0;
                 }else{
                     if(i == m-1 || j == n-1){
                       if(i == m-1 && j==n-1){
                           result[i][j] = 1;
                       }else if(i == m-1){
                           result[i][j] = result[i][j+1];
                       }else{
                           result[i][j] = result[i+1][j];
                       }
                     }else{
                         result[i][j] = result[i+1][j] + result[i][j+1];
                     }
                 }
            }
        }
        return result[0][0];
        
    }
}