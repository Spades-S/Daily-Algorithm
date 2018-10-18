### 033 Search in Rotated Sorted Array

#### Problem

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., `[0,1,2,4,5,6,7]` might become `[4,5,6,7,0,1,2]`).

You are given a target value to search. If found in the array return its index, otherwise return `-1`.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of *O*(log *n*).



#### Example

```
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
```

```
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
```



#### Solutions

【分析】看完题目，我们可以知道本题是要在一个数组中找出特定的元素，并且对时间复杂度有要求，需要满足*O*(log *n*)，二分查找的时间复杂度正好是*O*(log *n*)，满足条件。

**但是能使用二分查找的必要条件，数组是有序数组，但是题目中提到了，该数组是某个有序数组数组在某个位置打乱得到的。这个是本题的难点。**

大方向上，用二分查找，当中间位置的值不等于target时，需要分情况处理，是将左起点移动到mid位置，还是将右终点移动到mid位置。

**有一个解题思路比较好：判断中间位置的值和右终点的值关系，如果是mid-value > R-value，说明当前数组肯定是被打乱的有序数组，并且此时L-mid段内是有序的，接着可通过首末位置判断target是否在L-mid 这一有序段内，如果在，R = mid - 1，否则 L = mid + 1；如果mid-value <= R-value，则mid-R段内是有序的，同理可以通过判断target否在该段内，而决定移动左起点还是右终点。 **

```java
class Solution {
    public int search(int[] nums, int target) {
        int length = nums.length;
        if(length == 0){
            return -1;
        }
        int L = 0, R = length - 1;
        while(L <= R){
            int M = (R - L)/2 + L;
            if(nums[M] == target){
                return M;
            }else if(nums[M] > nums[R]){
                if(nums[L]<=target && nums[M] >= target){
                    R = M - 1;
                }else{
                   L = M + 1; 
                }                
            }else{
                if(nums[M]<=target && nums[R] >= target){
                    L = M + 1;
                }else{
                    R = M - 1;
                }
            }
        }

        return -1;
    }
}
```







### 081 Search in Rotated Sorted Array II



#### Problem

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., `[0,0,1,2,2,5,6]` might become `[2,5,6,0,0,1,2]`).

You are given a target value to search. If found in the array return `true`, otherwise return `false`.



#### Example

```
Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
```

```
Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false
```



#### Solutions

【分析】**081** 和 **033** 的区别在于数组中可以包含重复数字，返回的是bool值，不再是index。

【方法 一】由于返回的是bool值，我们可以先对数组排序，在使用二分法进行查找。时间复杂度 *O*(N log *N*)，主要时间花费在排序上。

```java
class Solution {
    public boolean search(int[] nums, int target) {
        int length = nums.length;
        if(length == 0){
            return false;
        }
        Arrays.sort(nums);
        int start = 0, end = length -1;
        while(start <= end){
            int mid = (start + end)/2;
            if(nums[mid] == target){
                return true;
            }else if(nums[mid] < target){
                start = mid + 1;
            }else{
                end = mid - 1; 
            }
        }
        return false;
    }
}
```

**这个方法是有致命缺陷的，当要求返回index时，该方法将失效。**

【方法二】基于 **033** 的解题方法.

在 **033** 中：

```java
if(nums[M] > nums[R]){
    // 此时左半部分是有序的
}else{
    // else 对应的情况只有 nums[M] < nums[R]，因为数组中没有重复元素
    // 此时右半部分有序的
}
```

在 **081** 中：

```java 
if(nums[M] > nums[R]){
    // 此时左半部分是有序的
}else{
    // else 对应的情况包含 nums[M] < nums[R] 和 nums[M] == nums[R] 因为数组中存在重复元素
    // 当nums[M] < nums[R] 时，右半部分是有序的
    // 当nums[M] == nums[R]时，不能确定，此时 R递减
    // 之所以可以使用R--，是因为在循环最开始就有当nums[M] == target 时会return，代码能够执行到
    // 这里可以确定R肯定不是所求值，故可以通过递减，排除R
}
```





```java
class Solution {
    public boolean search(int[] nums, int target) {
        int length = nums.length;
        if(length == 0){
            return false;
        }
        int L = 0, R = length - 1;
        while(L <= R){
            int M = (R - L)/2 + L;
            if(nums[M] == target){
                return true;
            }else if(nums[M] > nums[R]){
                if(nums[L]<=target && nums[M] >= target){
                    R = M - 1;
                }else{
                   L = M + 1; 
                }                
            }else if(nums[M] < nums[R]){
                if(nums[M]<=target && nums[R] >= target){
                    L = M + 1;
                }else{
                    R = M - 1;
                }
            }else{
                R--;
            }
        }

        return false;
    }
}
```



### 153 Find Minimum in Rotated Sorted Array

#### Problem
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.


#### Examples

```
Input: [3,4,5,1,2] 
Output: 1

```

```
Input: [4,5,6,7,0,1,2]
Output: 0

```


#### Solution
【分析】我的思路，分两类，一种是翻转过的，另一种未翻转过。
* 对于未翻转过的，第0个元素即为最小值
* 对于翻转过的，如何取得最小值？这里我考虑过两种：从nums.length - 1 处向前遍历；用二分法，二分法我没想到具体如何实现，故而采用了第一种方式

``` java 
class Solution {
    public int findMin(int[] nums) {
        int length = nums.length;
        if(length == 1){
            return nums[0];
        }
        if(nums[0] > nums[length -1]){
            for(int i = length -1; i>=0; i--){
                if(nums[i] < nums[i-1]){
                    return nums[i];
                }
            }
        }
        return nums[0];
    }
}
```

那么如果使用二分法应该如何实现呢？在使用二分法时，也仅是针对翻转过的数组。二分的本质是将mid赋给L还是R，在这里：
* 当 nums[mid] > nums[R] 时，明显是在左半边，这时需要将mid 赋给 L
* 当 nums[mid] < nums[R] 时，明显是在右半边，这时需要将mid 赋给 R
最终 R会处在最小值位置，即翻转位置，L = R - 1。

``` java
class Solution {
    public int findMin(int[] nums) {
        int length = nums.length;
        if(length == 1){
            return nums[0];
        }
        if(nums[0] > nums[length -1]){
            int L = 0, R = length - 1;
            while(L < R - 1){
                int mid = L + (R - L)/2;
                if(nums[mid] > nums[R]){ 
                    L = mid;
                }else{
                    R = mid;
                }
            }
            return nums[R];
        }
        return nums[0];
    }
}

```


### 154 Find Minimum in Rotated Sorted Array II

#### Problem
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

The array may contain duplicates.

#### Examples
```
Input: [1,3,5]
Output: 1

```

```
Input: [2,2,2,0,1]
Output: 0

```

#### Solution
【分析】在做到 `153` 时候，就猜到肯定有 `154`，这两题之间最大的差别就在于数组中是否存在重复元素。当数组中存在重复元素时，
* nums[0] < nums[nums.length - 1]时，必定可以推得该数组是未翻转过的
* nums[0] > nums[nums.length - 1]时，必定可以推得该数组是翻转过的
* nums[0] = nums[nums.length - 1]时，则不能确定。可能是违反转过，但数组值包含一个元素，如[1, 1, 1, 1 ,1]；也有可能是翻转过的，如[1, 1, 2, 3, 0, 1, 1]

如何处理：
* 处理未翻转过的数组时，和 `153` 一致， 直接返回 nums[0]
* 处理翻转过的数组、不能确定的数组：使用二分法，遍历相比较与二分，遍历还是太暴力了。

``` java 
int L = 0, R = length - 1;
while(L < R - 1){
    int mid = L + (R - L)/2;
    if(nums[mid] > nums[R]){ 
        // 此时mid处在左半段
        L = mid;
    }else if(nums[mid] < nums[R]){
        // 此时mid处在右半段
        R = mid;
    }else{
        // 不能确定，让R递减吧
        // 这里可能会有人问，如果数组只含有一个元素呢，R会一直递减直到，R = 1，返回结果依旧正确。
        R--;
    }
}
return nums[R];
```

全部代码：
``` java
class Solution {
    public int findMin(int[] nums) {
        int length = nums.length;
        if(length == 1){
            return nums[0];
        }
        if(nums[0] >= nums[length -1]){
            int L = 0, R = length - 1;
            while(L < R - 1){
                int mid = L + (R - L)/2;
                if(nums[mid] > nums[R]){ 
                    L = mid;
                }else if(nums[mid] < nums[R]){
                    R = mid;
                }else{
                    R--;
                }
            }
            return nums[R];
        }
        return nums[0];
    }
}
```










