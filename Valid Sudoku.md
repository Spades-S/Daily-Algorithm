### 036 Valid Sudoku

#### Problem

Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

- Each row must contain the digits 1-9 without repetition.
- Each column must contain the digits 1-9 without repetition.
- Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

![20181106150307.png](https://i.loli.net/2018/11/06/5be13cac0642a.png)

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

#### Examples

```
Input:
[
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: true
```

```
[
  ["8","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: false
```

#### Note

- A Sudoku board (partially filled) could be valid but is not necessarily solvable.
- Only the filled cells need to be validated according to the mentioned rules.
- The given board contain only digits 1-9 and the character '.'.
- The given board size is always 9x9.

#### Solution

【分析】本题是比较简单的，对照三个规则依次去验证即可，通过 HashSet 去判断有没有重复。最基本的方式，每一个规则都做一次 for 循环；更进一步地，将列和行两个规则对应的 for 循环合并成一个；再进一步将三个规则对应的 for 循环均合并成一个。

```java
class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++){
            HashSet<Character> setRow = new HashSet<Character>();
            HashSet<Character> setCol = new HashSet<Character>();
            HashSet<Character> setSub = new HashSet<Character>();
            for(int j = 0; j < 9; j++){
                char cRow = board[i][j];
                char cCol = board[j][i];  //将column环合并到row循环中
                char cSub = board[i/3*3 + j/3][i%3*3 + j%3]; //将subBox循环合并到row循环中
                if(cRow != '.'){
                    if(setRow.contains(cRow)) return false;
                    setRow.add(cRow);
                }
                if(cCol != '.'){
                    if(setCol.contains(cCol)) return false;
                    setCol.add(cCol);
                }
                if(cSub != '.'){
                    if(setSub.contains(cSub)) return false;
                    setSub.add(cSub);
                }
            }
        }
        return true;
    }

}
```
