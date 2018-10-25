### 268 Missing Number

#### Problem
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

#### Examples
```
Input: [3,0,1]
Output: 2

```

```
Input: [9,6,4,2,3,5,7,0,1]
Output: 8

```

#### Solution
【分析】输入数组中的元素肯定在 0 - n 之间，我们可以新建一个标记数组flag，flag是一个boolean数组，初始值均为false，遍历输入数组将flag[input [index]]位置为true，最后遍历flag数组，值为false的元素下标即为缺失的数值，返回对应下标即可。

``` java 
class Solution {
    public int missingNumber(int[] nums) {
        int len = nums.length + 1;
        boolean[] flag = new boolean[len];
        for(int num : nums){
            flag[num] = true;
        }
        for(int i = 0; i < len; i++){
            if(!flag[i]) return i;
        }
        return 0;
    }
}

```

【优化空间复杂度】这个方法非常棒。基于 a ^ b ^ b = a。依次对输入数组中的所有元素 、0-n这n个数做异或，最终剩下的就是确实的那个数。

``` java
class Solution {
    public int missingNumber(int[] nums) {
		int res = nums.length;
        for(int i = 0; i < nums.length; i++){
			res = res ^ i ^ nums[i];
        }
        return res;
    }
}
```

