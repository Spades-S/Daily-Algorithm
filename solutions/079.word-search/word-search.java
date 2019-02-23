class Solution {
    public boolean exist(char[][] board, String word) {
        List<Integer[]> coordinate = new ArrayList<Integer[]>();
        int m = board.length;
        // 排除空数组
        if(m==0){
            return false;
        }
        int n = board[0].length;
        if(n==0){
            return false;
        }
        // 排除word为空
        if(word.length()==0){
            return false;
        }
        
        
        for(int i= 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(i, j, 0, word, board)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean dfs(int x, int y, int nth , String word, char[][] board){
        // 是否越界
        if(x < 0 || y < 0 || x >= board.length || y >= board[0].length){
            return false;
        }

        if(board[x][y] == word.charAt(nth)){
            // 截止条件
            if(nth == word.length() - 1){
                return true;
            }
            char temp = board[x][y];
            board[x][y] = '@';
            // 寻找下一个
            if( dfs(x-1, y, nth+1, word, board) 
               || dfs(x+1, y, nth+1, word, board) 
               || dfs(x, y-1, nth+1, word, board) 
               || dfs(x, y+1, nth+1, word, board)){
                return true;
            }
            board[x][y] = temp;
        }
        return false;
    }
}