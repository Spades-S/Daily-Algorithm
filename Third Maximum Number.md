### 414 Third Maximum Number

#### Problem

Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).

#### Examples

```
Example 1:
Input: [3, 2, 1]

Output: 1

Explanation: The third maximum is 1.
```

```
Input: [1, 2]

Output: 2

Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
```

```
Example 3:
Input: [2, 2, 3, 1]

Output: 1

Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.
```

#### Solution

【分析】总体上来说这题还算是比较简单的，是在不行就遍历 3 次，分别找出 firstMaximum、secondMaximum、ThirdMaximum，最后再看 ThirdMaximum 是否存在，存在则返回，不存在返回 firstMaximum。

```java
class Solution {
    public int thirdMax(int[] nums) {
        int len = nums.length;
        int max = nums[0];
        boolean existMIN = false;
        for(int num : nums){
            if(num == Integer.MIN_VALUE) existMIN = true;
            max = num >= max ? num : max;
        }
        if(len <=2 ) return max;
        int[] maxs = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
        maxs[0] = max;
        max = Integer.MIN_VALUE;
        for(int num : nums){
            max = num > max && num != maxs[0] ? num : max;
        }
        maxs[1] = max;
        max = Integer.MIN_VALUE;
        for(int num : nums){
            max = num > max && num != maxs[0] && num != maxs[1] ? num : max;
        }
        if(max != Integer.MIN_VALUE || (existMIN && maxs[1] != Integer.MIN_VALUE)) return max;
        return maxs[0];
    }
}
```

在上述实现中，在遍历之前我都会将值赋值为 Integer.MIN_VALUE，在最后判断 thirdMaximum 是否存在时不能仅仅通过 max == Integer.MIN_VALUE 就断定不存在 thirdMaximum，因为有可能 thirdMaximum 就是 Integer.MIN_VALUE。在上述实现中，通过一个标志位来判断 nums 中是否存在 Integer.MIN_VALUE 以及 secondMaximum != Integer.MIN_VALUE，来判断 thirdMaximum 是否就是 Integer.MIN_VALUE，以避免误判而错误输出。但是这种实现并不好。

【Integer.MIN_VALUE -> Long.MIN_VALUE】用 Long.MIN_VALUE 去替换 Integer.MIN_VALUE 是更好的实现。

```java
class Solution {
    public int thirdMax(int[] nums) {
        int len = nums.length;
        long max = nums[0];
        for(int num : nums){
            max = num >= max ? num : max;
        }
        if(len <=2 ) return (int)max;
        long[] maxs = new long[]{Long.MIN_VALUE, Long.MIN_VALUE};
        maxs[0] = max;
        max = Long.MIN_VALUE;
        for(int num : nums){
            max = num > max && num != maxs[0] ? num : max;
        }
        maxs[1] = max;
        max = Long.MIN_VALUE;
        for(int num : nums){
            max = num > max && num != maxs[0] && num != maxs[1] ? num : max;
        }
        if(max != Long.MIN_VALUE ) return (int)max;
        return (int)maxs[0];
    }
}
```

【降低时间复杂度】其实还可以只遍历一次数组就完成查找。

```java
class Solution {
    public int thirdMax(int[] nums) {
        int len = nums.length;
        long[] maxs = new long[]{Long.MIN_VALUE, Long.MIN_VALUE, Long.MIN_VALUE};
        for(int num : nums){
					if(num > maxs[0]){
						// 注意更新顺序
						maxs[2] = maxs[1];
						maxs[1] = maxs[0];
						maxs[0] = num;
					}else if(num < maxs[0] && num > maxs[1]){
						maxs[2] = maxs[1];
						maxs[1] = num;
					}else if(num < maxs[1] && num > maxs[2]){
						maxs[2] = num;
					}
        }
				if(maxs[2] != Long.MIN_VALUE) return (int)maxs[2];
				return (int)maxs[0];
    }
}
```
