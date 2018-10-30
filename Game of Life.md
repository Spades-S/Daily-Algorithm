### 289 Game of Life

#### Problem
According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state. The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.


#### Example
```
Input: 
[
  [0,1,0],
  [0,0,1],
  [1,1,1],
  [0,0,0]
]
Output: 
[
  [0,0,0],
  [1,0,1],
  [0,1,1],
  [0,1,0]
]
```


#### Solution
【分析】本题是常规题，可以利用ArrayList暂存变化元素，最终一并更新数组。

``` java
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

```

【位操作方式】利用位操作方式可以省去ArrayList的空间开销，但需要遍历数组两次，第一次遍历数组时，将活着的元素置为3，将死掉的元素置为2，此时在判断元素board[x][y]是否存活的判断方式应该为：
(board[x][y] & 1) == 0 ，成立则说明当前元素board[x][y]已经死掉了。第二次遍历将数组中的每一个元素均右移一位，恢复0 、1 表示。这是一种用时间换空间的做法。