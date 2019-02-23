class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        if(rows == 0){
            return false;
        }
        int cols = matrix[0].length;
        int start = 0, end = rows*cols -1;
        while(start <= end){
            int m = (end - start)/2 + start;
            int x = m / cols;
            int y = m % cols;
            if(matrix[x][y] == target){
                return true;
            }else if(matrix[x][y] > target){
                end = m -1  ;
            }else{
                start = m + 1 ;
            }
        }
       return false;
    }
}