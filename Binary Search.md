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


### 162 Find Peak Element

#### Problem

A peak element is an element that is greater than its neighbors.

Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that nums[-1] = nums[n] = -∞.

#### Examples

```
Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.

```

```
Input: nums = [1,2,1,3,5,6,4]
Output: 1 or 5 
Explanation: Your function can return either index number 1 where the peak element is 2, 
             or index number 5 where the peak element is 6.

```

#### Note

Your solution should be in logarithmic complexity.


#### Solution
【分析】如果这道题没有时间复杂度是O(log n) 的要求的话，暴搜也不失为一个方法。

【暴搜】
``` java
class Solution {
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        if(len == 1) return 0;
        for(int i = 0; i < len; i++){
            if(i == 0){
                if(nums[0] > nums[1]) return 0;
            }else if(i == len - 1){
                if(nums[i] > nums[i - 1]) return i;
            }else{
                if(nums[i] > nums[i-1] && nums[i] > nums[i+1]) return i;
            }
        }
        return 0;
    }
}

```

但是不巧的是，题目要求了时间复杂度，并且时间复杂度是 O(log n)，二分查找时符合条件的。试试二分查找。二分查找最关键的就是将mid值赋给left还是right，如果能找到这个点，就解决了一半了。我们来看一下这个题，要找的是局部的峰值：
* 当nums[mid] > nums[mid+1]时，[left, mid]区间之内必定存在局部峰值
* 当nums[mid] < nums[mid+!]时，[mid+1, right]区间之内必定存在局部峰值

找到了mid赋值方向之后，就是算法实现了，常见的二分查找实现方式：
* 左闭右开
    * mid -> left: left = mid + 1
    * mid -> right: right = mid
    * 截止条件: left < right
    * 起始条件: left = 0, right = nums.length
    * 如果没有找到: left = right
* 左闭右闭
    * mid -> left: left = mid + 1
    * mid -> right: right = mid - 1
    * 截止条件: left <= right
    * 起始条件: left = 0, right = nums.length - 1
    * 如果没有找到: left = right + 1

【问题1】为什么左闭右开实现截止条件是 left < right，而左闭右闭实现截止条件是 left <= right
【回答】因为当left = right时，对于左闭右开来说，此时该值是取不到的，而对左闭右闭，是可以取到的。

对于本题来说，如果使用左闭右闭的方式，最终需要判断nums[left] 和 nums[right]之间的大小关系，并且有可能出现 right = -1 或者是 left = nums.length 的情况出现。如果使用左闭右开的方式，将right的初始值设置为 nums.length - 1，我们可以确保最终 left = right 且 该值在[0, nums.length - 1]之间，且该值为所求值。

【疑问1】如果nums数组的最后一位为所求峰值怎么办？
【回答】举个例子，假定数组为[1, 2, 3, 4]，此时峰值为第 3 位。 使用左闭右开方式，初始值 right = 3，最终会有 right = left = 3，最终只需要返回 left或者right即可。如果出现在数组中间最后会回到初始值为数组最后一位的情况。

``` java
class Solution {
    public int findPeakElement(int[] nums) {
        int L = 0, R = nums.length - 1;
        while(L < R){
            int mid = L + (R - L)/2;
            if(nums[mid] > nums[mid + 1]){
                R = mid;
            }else{
                L = mid + 1;
            }
        }
        return R;
    }
}
```



### Binary Search

* 左闭右开
    * 当target > nums[mid], 此时有 mid -> left: left = mid + 1
    * 当target < nums[mid], 此时有 mid -> right: right = mid
    * 当target = nums[mid], 直接返回
    * 截止条件: left < right
    * 起始条件: left = 0, right = nums.length
    * 如果没有找到: left = right
* 左闭右闭
    * 当target > nums[mid], 此时有 mid -> left: left = mid + 1
    * 当target < nums[mid], 此时有 mid -> right: right = mid - 1
    * 当target = nums[mid], 直接返回
    * 截止条件: left <= right
    * 起始条件: left = 0, right = nums.length - 1
    * 如果没有找到: left = right + 1

【问题1】为什么左闭右开实现截止条件是 left < right，而左闭右闭实现截止条件是 left <= right
【回答】因为当left = right时，对于左闭右开来说，此时该值是取不到的，而对左闭右闭，是可以取到的。












