class Solution {
    public void gameOfLife(int[][] board) {
        List<int[]> changed  = findNeedToChange(board);
        for(int[] item : changed){
            board[item[0]][item[1]] = 1 - board[item[0]][item[1]];
        }
    }
    public List<int[]> findNeedToChange(int[][] board){
        List<int[]> changed = new ArrayList<int[]>();
        int m = board.length; 
        if(m<1) return changed;
        int n = board[0].length;
        for(int x = 0; x < m; x++){
            for(int y = 0; y < n; y++){
                int liveNeighbors = findLiveNeighbors(board, x, y);
                if(board[x][y] == 0 && liveNeighbors == 3)
                    changed.add(new int[]{x, y});
                if(board[x][y] == 1 && ( liveNeighbors < 2 || liveNeighbors > 3 ))
                    changed.add(new int[]{x, y});
            }
        }
        return changed;
        
    }
    
    public int findLiveNeighbors(int[][] board, int x, int y){
        int m = board.length, n = board[0].length;
        int cnt = 0;
        if(x-1>=0){
            if(board[x-1][y] == 1) cnt++;
            if(y-1>=0 && board[x-1][y-1] == 1) cnt++;
            if(y+1 < n && board[x-1][y+1] == 1) cnt++;
        }
        if(x+1<m){
            if(board[x+1][y] == 1) cnt++;
            if(y-1>=0 && board[x+1][y-1] == 1) cnt++;
            if(y+1<n && board[x+1][y+1] == 1) cnt++;
        }
        if(y-1>=0 && board[x][y-1] == 1) cnt++;
        if(y+1<n && board[x][y+1] == 1) cnt++;
        return cnt;
    }
}