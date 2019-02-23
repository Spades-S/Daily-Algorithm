class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        HashSet<Integer> row = new HashSet<Integer>(), column = new HashSet<Integer>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j]==0){
                    row.add(i);
                    column.add(j);
                }
            }
        }
        for(int i : row){
            for(int j = 0; j< n;j++){
                matrix[i][j] = 0;
            }
        }
        for(int j : column){
            for(int i = 0; i < m; i++){
                matrix[i][j] = 0;
            }
        }
    }
}