#### Problem

Write an efficient algorithm that searches for a value in an *m* x *n* matrix. This matrix has the following properties:

- Integers in each row are sorted from left to right.
- The first integer of each row is greater than the last integer of the previous row.



#### Example

```
Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true
```

```
Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
Output: false
```



#### Solutions

【分析】本质上是一个二分查找。二分查找中比较关键的部分：while(start <= end) 中的 `=` 号，以及 `if(middle < target) { start = middle + 1 }` 和 `if(middle > targer) { end = middle -1}` 中的 加减`1`

```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        if(rows == 0){
            return false;
        }
        int cols = matrix[0].length;
        int start = 0, end = rows*cols -1;
        while(start <= end){
            int m = (end - start)/2 + start;
            int x = m / cols;
            int y = m % cols;
            if(matrix[x][y] == target){
                return true;
            }else if(matrix[x][y] > target){
                end = m -1  ;
            }else{
                start = m + 1 ;
            }
        }
       return false;
    }
}
```

