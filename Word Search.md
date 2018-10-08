### 079 Word Search

#### Problem

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.



#### Example

```
board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
```



#### Solutions

【分析】题目里有一个硬性要求，每个元素只能用一次，所以我们需要一个标志位，用以标识该元素是否被使用过。这是一道典型的DFS题目。

深度优先搜索时需要关注截止条件，由于题目条件是一个二维数组，还需要关注数组是否越界。



```java
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
```

