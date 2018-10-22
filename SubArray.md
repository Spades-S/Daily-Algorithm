### 053 Maximum SubArray

#### Problem

Given an integer array `nums`, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

#### Example

```
Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
```

#### Solutions

这道题我拿到之后想到的是找到始末位置，题目里面已经提及了是连续的子数组，只要能找到始末位置，就可以拿到子数组，从而求和。这应该算是一个很正常的想法。但是这个想法却难以实践。首先我们不确定哪个是开始位置，这是难以确定的，数组长度为n的话，就有n种可能。结束位置更加难以确定，因为没有判定条件，我们不清楚什么是终止条件，在怎样的情况下才算是符合终止条件。故而这个想法胎死腹中。

看了别人的解题思路，用动态规划。本质在于全局的最优解肯定包含着某个子数组的最优解：在本题中对应于全局的最大和肯定不小于子数组的最大和。全局最大和 = max(全局最大和, 子数组最大和)。

第i位最大和的DP方程：sum[i] = Math.max(sum[i-1] + nums[i], nums[i])。

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0], result = nums[0];
        for(int i = 1; i < nums.length; i++){
            sum = sum > 0 ? sum + nums[i] : nums[i];
            result = sum > result ? sum : result;  // 全局最大和和局部最大和比较、更新
        }
        return result;
    }
}
```


### 152 Maximum Product Subarray

#### Problem
Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

#### Examples

```
Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

```


```
Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

```


#### Solution
【分析】本题和 `053` 均采用动态规划方式进行解答。而不同的地方在于，本题的DP方程更难找到。对于 `053` ，比较容易能够得到其DP方程，当前最大子数组和等于上一个位置最大子数组和+当前值，即sum[i] = sum[i-1] + nums[i]。

而在本题中当前最大乘积 product[i] != product[i-1] * nums[i]。在本题中我们需要用到两个DP数组，分别对应当前位置i处最大乘积和最小乘积，分别记为 pdMax[i]、pdMin[i]，记录最大值和最小值的目的在于，当前位置的最大值可能为 nums[i] * pdMax[i-1]、nums[i]、nums[i]*pdMin[i-1]。

| 第i个位置最大乘积|  原因  | 
| :--- |:---- | 
|nums[i] * pdMax[i-1]| nums[i]和pdMax[i-1]同号，常见情况均为正|
|nums[i]|pdMax[i-1]值为0，nums[i]值不为负|
|nums[i]*pdMin[i-1]| nums[i]和pdMin[i-1]值均为负|

从而 pdMax[i] = Math.max(pdMax[i-1] * nums[i], nums[i], pdMin[i-1] * nums[i])，类似地，pdMin[i] = Math.min(pdMax[i-1] * nums[i], nums[i], pdMin[i-1] * nums[i])

``` java
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        int res = nums[0];
        int arrMax = nums[0];
        int arrMin = nums[0];
        for(int i = 1; i < n; i++){
            int larger = 0, smaller = 0;
            if(arrMax*nums[i] > arrMin*nums[i]){
                larger = arrMax*nums[i];
                smaller = arrMin*nums[i];
            }else{
                smaller = arrMax*nums[i];
                larger = arrMin*nums[i];                
            }
            arrMax = larger > nums[i] ? larger : nums[i];
            arrMin = smaller < nums[i] ? smaller : nums[i];
            if(res < arrMax) res = arrMax;
        }
        return res;
    }
}
```



### 209 Minimum Size Subarray Sum

#### Problem 
Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

#### Example
```
Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: the subarray [4,3] has the minimal length under the problem constraint.

```

#### Solution
【分析】在思考这道题的时候，考虑过遍历，sum += nums[i] 的方式寻找子数组，但是没有想到当找到 sum >= s 时，如何去更新最短距离。
【更新最短距离】使用两个指针，left 和 right，分别记录子数组左右边界的位置，让right向右移动，当子数组和大于等于给定的值时，将左指针向右移动直到，子数组和小于给定的值，更新最短距离。

``` java
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0, res = 0;
        for(int left = 0, right = 0; right < nums.length; right++){
            sum += nums[right];
            if(sum >= s){
                while(left <= right){
                    if(sum - nums[left] < s){
                        int sub = right - left + 1;
                        res = res == 0 ? sub : (res > sub) ? sub : res;  
                        break;
                    }
                    sum -= nums[left];
                    left++;
                }
            }
        }
        return res;
    }
}
```
这里需要关注下：
* while循环终止条件，`left <= right` 和 `sum - nums[left] < s` 这两个条件
* 最短距离是 right - left + 1， 这里 `+ 1` 是因为此时left包含在子数组中

【问题1】为什么left 可以取到 right？
【回答】 如果nums[right] == s，只有当left == right 时，方有 sum - nums[left] < s


【另一种方法】建立一个比原数组长一位的数组sums，其中sums[i] 表示 nums数组中0-i-1位元素的和，其中sums[0] = 0。对于sums数组，sums[m] - sum[n]表示子数组 nums[n ... m-1]，其中m > n。在nums中寻找子数组使得该子数组和大于等于指定值 -> 在sums[i+1 ... nums.length]中找到一个元素sums[x]，使得 sums[x] >= sums[i] + 指定值。而由于sums是一个递增数组，故而可以通过二分查找来确定x。该方法的时间复杂度为 O(log n)。

``` java
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        int res = 0;
        int[] sums = new int[len + 1];
        sums[0] = 0;
        for(int i = 1; i <= len; i++){
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for(int i = 0; i < len; i++){
            int right = helper(sums, i + 1, len, sums[i] + s);
            if(right > len) break;
            res = res == 0 ?right - i : right - i > res ? res : right -i; 
        }
        return res;
    }
    
    public int helper(int[] sums,  int left, int right, int target){
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(sums[mid] >= target) {
               right = mid - 1; 
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}
```

个人而言我更喜欢双指针法。








