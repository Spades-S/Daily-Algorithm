### 238 Product of Array Except Self

#### Problem

Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

#### Example
```
Input:  [1,2,3,4]
Output: [24,12,8,6]

```

#### Solution
【分析】本题实现起来不难，即便是用常数空间复杂度(返回的结果的空间不算在内)实现起来也不难。难点在于想法，数组中除元素自身之外的其他元素之积，可以转化成，该元素之前的所有元素的积 * 该元素之后的所有元素的积。

``` java
class Solution{
	public int[] productExceptSelf(int[] nums){
		int len = nums.length;
		int[] before = new int[len], after = new int[len];
		before[0] = 1;
		after[len - 1] = 1;
		for(int i = 1; i < len; i++){
			before[i] = before[i - 1]*nums[i - 1];
		}
		for(int i = len - 2; i > -1; i--){
			after[i] = after[i + 1]*nums[i + 1];
		}
		for(int i = 0; i < len; i++){
			before[i] *= after[i];
		}
		return before;
	}
}

```

以 [1, 2, 3, 4]为例分析下：

| | 0 | 1 |2 |3|
|:-|:-|:-|:-|:-|
|nums| 1 | 2 | 3| 4|
|before| 1 | 1 * 1| 1 * 1 * 2| 1 * 1 * 2 * 3|
|afer| 2 * 3 * 4 * 1| 3 * 4 * 1|4 * 1|1|

最终要返回的刚好是after[i]*before[i]。

【优化空间复杂度】after和before两个数组中只保留一个，另个一的值可以在for循环中得到。以保留before为例：
``` java 
class Solution{
	public int[] productExceptSelf(int[] nums){
		int len = nums.length;
		int[] before = new int[len];
		before[0] = 1;
		for(int i = 1; i < len; i++){
			before[i] = before[i - 1]*nums[i - 1];
		}
		int right = 1;
		for(int i = len - 1; i > -1; i--){
			before[i] *= right;
			right *= nums[i];
		}
		
		return before;
	}
}

```
第一个循环不用多说，会得到before数组，现在来看下第二个循环，以 [1, 2, 3, 4] 为例：

| index | right | before[index]|
|:--|:--|:--|:--|
| 3 | 1 | 1* 2 * 3 * 1|
| 2 | 1 * 4 | 1* 2 * 4 * 1| 
| 1 | 1 * 4 * 3 | 1 * 4 * 3 * 1|
| 0 | 1 * 4 * 3 * 2 | 1 * 4 * 3 * 2 * 1| 

在每次循环时，right都会更新为当前index右侧所有的值的积。

【问题1】那可以不可再优化空间复杂度呢？
【回答】 不可以，因为得到before数组 和 after数组的遍历顺序并不相同，不可能将两个循环合并为一个，从而也就无法再次降低空间复杂度


