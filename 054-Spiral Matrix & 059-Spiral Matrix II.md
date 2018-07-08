### 054 Spiral Matrix

#### Problem

Given a matrix of *m* x *n* elements (*m* rows, *n* columns), return all elements of the matrix in spiral order.

#### Example

```
Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
```

```
Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
```



#### Solutions

分析：题目要求螺旋式读取，最直接的想法，**只要能够判断如何是否是转折点，下一步是水平/竖直？增加/减少？想通过这种方法去解决问题，如果之前没有看过类似的解答技巧，是很难想出来的。至少我没有想出来，毕竟判断转折以及下一个位置如何确定，还是一个很艰难的问题。**

既然第一个方法没有走通，那可不可以换一个思路呢？前一种方法卡在了**转折点和下一个位置如何确定上**，那我们是否可以直接简化这个步骤呢，比如在一层循环中指定何时转折以及如何转折。按照这个思路往下思考，最终可以想出**一层一层地去做螺旋**。

一层一层地螺旋，也就是将二维数组分为若干层，最外圈的为`第0层`，次外圈为`第1层`，对于一个二维数组最多可以分为 n层，其中n的值为：```min(width-1, height-1)/2```，其中width为二维数组宽度，height为二维数组高度。

对于每一层，首先我们需要确定四个顶点，第n层四个顶点分别为：左上: (n,n)，右上: (n, width-n-1)，右下: (height-n-1,width-n-1)，左下: (height-n-1,n)。确定了四个顶点之后，实现螺旋读取就很简单了。

```java
// java  
// 左上 -> 右上
  x=n;
  y=n;
  while(y< width - n){
    result.add(matrix[x][y]);
    y++;
  }
// 右上 -> 右下
  y = width - 1 - n;
  x = n + 1;
  while(x < height - n){
    result.add(matrix[x][y]);
    x++;
  }
// 右下 -> 左下
  x = height - n -1;
  y = width - n - 2;
  while(y>=n){
    result.add(matrix[x][y]);
    y--;
  }
// 左下 -> 左上
  x = height - n -2;
  y = n;
  while(x>n){
    result.add(matrix[x][y]);
    x--;
  }
```

以上就是螺旋读取的过程，其中result是最终的结果，是List类型。

到这里其实已经完成了算法的核心部分，不过需要留意，按上述代码处理每一层的螺旋过程可能出现重复。当第n层为：[22, 23, 24]时，从右下到左下读取时会造成重复，原因在于在这种情况下左上到右上、右下到左下本质上所涉及的都是这三个数，需要将这种情况排除。同样当第n层为`[[23][24][22]]`时，从右下到左上的过程会造成重复。

```java
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
```

完整代码如下：

```java
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
```



#### Summary

一层一层循环是很便于理解的，也是常规情况下能够想到的。在leetcode的solution中给出了**转折点+下一个位置在哪儿**的解题方法。

```java
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List ans = new ArrayList();
        if (matrix.length == 0) return ans;
        int R = matrix.length, C = matrix[0].length;
        boolean[][] seen = new boolean[R][C];
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int r = 0, c = 0, di = 0;
        for (int i = 0; i < R * C; i++) {
            ans.add(matrix[r][c]);
            seen[r][c] = true;
            int cr = r + dr[di];
            int cc = c + dc[di];
            if (0 <= cr && cr < R && 0 <= cc && cc < C && !seen[cr][cc]){
                r = cr;
                c = cc;
            } else {
                di = (di + 1) % 4;
                r += dr[di];
                c += dc[di];
            }
        }
        return ans;
    }
}
```

这个方法还是挺有意思的，核心的几个东西：

```java
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0}; // 这两个数组是需要人为总结出来的，这个数组里包含了螺旋顺序
        boolean[][] seen = new boolean[R][C]; // 这个数组是为了判断是否要由当前层进入下一层
```



### 059 Spiral Matrix II

#### Solution

解题思路和054一样，分层处理。054 是从分层中读取数据，059是往每一个分层中写入数据。

```java
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
```

