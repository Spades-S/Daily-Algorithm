class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int layer = n/2, i = 0,num = 1; // layer => 总层数，i => 当前是第几层，num => 当前需要填充的数值
        while(i<=layer){
            int x = i, y = i;
            while(y<n-i){
                result[x][y] = num;
                num++;
                y++;
            }
            
            x = i+1; y = n-i-1;
            while(x<n-i){
                result[x][y] = num;
                num++;
                x++;
            }
            
            if(n-1-i>i){
                x = n-1-i;
                y = n-2-i;
                while(y >= i){
                    result[x][y] = num;
                    num++;
                    y--;
                }
                
                x = n-i-2;
                y = i;
                while(x > i){
                    result[x][y] = num;
                    num++;
                    x--;
                }
            }
            
            i++;
        }
        return result;
        
        
    }
}