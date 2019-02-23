class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if(matrix.length<1){
            return result;
        }
        int width = matrix[0].length, height = matrix.length;
        int n = 0; // 第几圈
        int x = 0, y = 0; //元素坐标
        while(n<= (Math.min(width-1, height-1))/2){
            x=n;
            y=n;
            while(y< width - n){
                result.add(matrix[x][y]);
                y++;
            }
            y = width - 1 - n;
            x = n + 1;
            while(x < height - n){
                result.add(matrix[x][y]);
                x++;
            }
            x = height - n -1;
            y = width - n - 2;
            while(y>=n && x>n){
                result.add(matrix[x][y]);
                y--;
            }
            x = height - n -2;
            y = n;
            while(x>n && y<width-n-1){
                result.add(matrix[x][y]);
                x--;
            }
            n++;   
        }
        return result;
        
      
    }
}