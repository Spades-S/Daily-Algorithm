class Solution {

    public int uniquePaths(int m, int n) {
        int[][] result = new int[m][n];
        for(int i= m-1; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){
                if(i==m-1 || j == n-1) {
                  result[i][j]=1;  
                }else{
                    result[i][j] = result[i+1][j] + result[i][j+1];
                }
            }
        }
        return result[0][0];
    }
}


