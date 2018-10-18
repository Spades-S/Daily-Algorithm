### 120 Triangle

#### Problem
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

#### Example
Given the following triangle,
```
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]

```
The minimium path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11)

#### Solution
【分析】本题是DP问题。DP方程比较容易可以得到：sum[i][j] = Math.min(sum[i + 1][j], sum[i + 1][j+1])+ nums[i][j]。 看到这道题我最先想到的是DFS，深度优先遍历，然后比较所在路径和的大小，最终得到最小和。

【DFS方式】

``` java
class Solution {
    private int sum = 0;
    private boolean once = false;
    public int minimumTotal(List<List<Integer>> triangle) {
        helper(triangle, 0, 0, sum);
        return sum;
    }
    public void helper(List<List<Integer>> triangle, int nth, int index, int currentSum){
        if(nth == triangle.size()){
            if(!once) {
                once = true;
                sum = currentSum;
            }else{
                if(sum > currentSum) sum = currentSum;
            }
            return;
        }
        currentSum += triangle.get(nth).get(index);
        helper(triangle, nth + 1, index, currentSum);
        helper(triangle, nth + 1, index + 1,currentSum);
    }
}
```

DFS方法在测试简单用例时完美通过，但是leetcode给了一个很长的数组，TLE。分析下TLE原因：上述解法中的DFS是不没有剪枝的，比如：2-3-5-... 和 2-4-5-... 中的5-...部分是重复的。这是造成TLE的主要原因。可以通过使用状态记录数组的方式加以解决。

解决方法如下：
```  java 
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int n = triangle.size();
        int[][] minSum = new int[n][n];
    
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                minSum[i][j] = Integer.MAX_VALUE;  // 状态记录数组
            }
        }
        return dfs(triangle, 0 , 0 , 0, minSum);
    }
    
    private int dfs(List<List<Integer>> triangle, int row, int column, int sum, int[][] minSum) {
        if (row >= triangle.size()) {
            return 0;
        }
        if (minSum[row][column] != Integer.MAX_VALUE) {  //剪枝过程
            return minSum[row][column];
        }
        minSum[row][column] = Math.min(dfs(triangle, row + 1, column, sum, minSum),
                               dfs(triangle, row + 1, column + 1, sum, minSum))
            + triangle.get(row).get(column);
        return minSum[row][column];
    }
}
```


【循环方式】DFS方式即递归方式，对于DP问题除了递归方式，还有循环方式。 按照从上到下、从左到右顺序遍历，遍历的同时修改当前值为到达该节点的最小和。最终比较最后一排大小，最小值为所求结果。
``` java
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int sum = triangle.get(0).get(0);
        for(int i = 1; i < triangle.size(); i++){
            for(int j = 0; j <= i; j++){
                if(j == 0){
                    triangle.get(i).set(j, triangle.get(i-1).get(j) + triangle.get(i).get(j));
                }else if(j == i){
                    triangle.get(i).set(j, triangle.get(i-1).get(j-1) + triangle.get(i).get(j));
                    
                }else{
                    triangle.get(i).set(j, Math.min(triangle.get(i-1).get(j), triangle.get(i-1).get(j-1)) + triangle.get(i).get(j));
                }
                if((i == triangle.size() -1) && (j == 0 || triangle.get(i).get(j)<sum)){
                    sum = triangle.get(i).get(j);
                }
            }
        }
        return sum;
    }
}
```

当时上述方式修改了原数组，这个方式不是很好，可以通过新建 triangle.size()大小的数组，保存到达当前节点的最小和。 数组更新过程如下，以题目所给 `Example` 为例。 ：

```
 2   X   X   X
 5   6   X   X
 11  10  13  X
 15  11  18  16
```

``` java
class Solution {
    private boolean once = false;
    public int minimumTotal(List<List<Integer>> triangle) {
        int sum = triangle.get(0).get(0);
        int[] tempArr = new int[triangle.size()];
        tempArr[0] = sum; 
        for(int i = 1; i < triangle.size(); i++){
            for(int  j = i;j >= 0; j--){
                if(j == 0){
                    tempArr[j] = tempArr[j] + triangle.get(i).get(j);
                }else if(j == i){
                    tempArr[j] = tempArr[j-1] +  triangle.get(i).get(j);
                }else{
                    tempArr[j] = Math.min(tempArr[j], tempArr[j - 1]) + triangle.get(i).get(j);
                }
                if((i == triangle.size() -1) && (j == i || tempArr[j]<sum)){
                    sum = tempArr[j];
                }
            }
        }
        return sum;
    }
}
```



