### 064
#### Problem

Given a *m* x *n* grid filled with non-negative numbers, find a path from top left to bottom right which *minimizes* the sum of all numbers along its path.

**Note:** You can only move either down or right at any point in time.

#### Example

```
Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.
```



#### Solutions

【分析】如果看到这题能够想到Dynamic Programming 了，也就基本解决了。重点可能就是dp方程了，不过也很容易就能找到：

```java
dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + gird[i][j];
```

本质上这题不难。

```java
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if(m<=0){
            return 0;
        }
        int n = grid[0].length;
        if(n<=0){
            return 0;
        }
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int i = 1;i < m; i++){
            dp[i][0]= dp[i-1][0]+grid[i][0];
        }
        for(int j = 1;j< n; j++){
            dp[0][j]= dp[0][j-1]+grid[0][j];
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }
        
        return dp[m-1][n-1];
        
    }
}
```

