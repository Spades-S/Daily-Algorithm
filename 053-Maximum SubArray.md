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

看了别人的解题思路，用动态规划。本质在于全局的最优解肯定包含着某个子数组的最优解：在本题中对应于全局的最大和肯定不小于子数组的最大和。全局最大和 = max(全局最大和, 子串最大和)

如何去除子数组有害部分：子数组有害部分是指子数组中连续部分和小于0的部分，这部分不会对找到最大和子数组提供到任何帮助，需要及时去除。sum是将每个元素相加后的值，当sum值小于0时，我们需要将目标子数组的起始位置重新定位到当前元素的下一个元素，即将sum置为零。

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0, result = nums[0];
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            result = Math.max(result, sum);
            if(sum < 0){
                sum = 0;
            }
        }
        return result;
    }
}
```



