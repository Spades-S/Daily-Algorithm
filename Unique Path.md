### 062 Unique Path

#### Problem

A robot is located at the top-left corner of a *m* x *n* grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

#### Example

```
Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Right -> Down
2. Right -> Down -> Right
3. Down -> Right -> Right
```

```
Input: m = 7, n = 3
Output: 28
```



#### Solutions

分析：实质上这题很简单，用排列组合就可以。题目的本意是要我们联系动态规划，那就老老实实地去用动态规划吧。找dp方程：

```
dp[x][y] = dp[x+1][y] + dp[x][y+1];
```

至此，解题结束。

```Java
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
```



### 063 Unique Paths II

#### problem

A robot is located at the top-left corner of a *m* x *n* grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

#### Example

```
Input:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
Output: 2
Explanation:
There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right
```

#### Solution

分析：这道题跟上一题其实很像，解题思路基本一致，只不过需要将含有障碍的路线排除。那么如何排除呢？

分两种情况：**对于不在第`m-1`行和第`n-1`列上的元素，只需要将其对应的路径值置为0即可，即`path[x][y]=0`，如果在第`m-1`行或者第`n-1`列上的元素呢？障碍元素所在位置及其之前的元素对应的路径值为0。即当(m-1,y)为障碍时，`path[m-1][y-1] = path[m-1][y] = 0 `，同样地，当(x,n-1)为障碍时，`path[x][n-1] = path[x-1][n-1] = 0 `**

```java
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if(m<1){
            return 0;
        }
        int n = obstacleGrid[0].length;
        int[][] result = new int[m][n];
        for(int i = m-1; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){
                 if(obstacleGrid[i][j]==1){
                        result[i][j] = 0;
                 }else{
                     if(i == m-1 || j == n-1){
                       if(i == m-1 && j==n-1){
                           result[i][j] = 1;
                       }else if(i == m-1){
                           result[i][j] = result[i][j+1];
                       }else{
                           result[i][j] = result[i+1][j];
                       }
                     }else{
                         result[i][j] = result[i+1][j] + result[i][j+1];
                     }
                 }
            }
        }
        return result[0][0];
        
    }
}
```

