### 287 Find the Duplicate Number

#### Problem
Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

#### Examples
```
Input: [1,3,4,2,2]
Output: 2

```

```
Input: [3,1,3,4,2]
Output: 3

```

#### Note

1. You must not modify the array (assume the array is read only).
2. You must use only constant, O(1) extra space.
3. Your runtime complexity should be less than O(n^2).
4. There is only one duplicate number in the array, but it could be repeated more than once.

#### Solution

【分析】题目里前两个要求分别是不能修改数组，且空间复杂度为常数，这两个要求基本杀死了先排序再查找、利用 HashSet 查重的思路。除此之外，还要求时间复杂度不能超过 O(n^2)，暴搜的方式也不可行。如果重复元素只重复出现一次的话，可以考虑用异或的方式去寻找。但是，题目给了四个要求，这几个方式都不行。sad。

【弗洛伊德判断算法】
首先我们需要将问题转化为环查找问题。记输入数组为nums。

【映射】我们将输入数组nums的下标index和nums[index]做一个一对一映射，假设这个映射关系是f(n)，其中n表示nums的下标，f(n)是映射到的数值nums[n]。如果我们从下标0出发，根据映射函数f(n)计算出一个数值，再将计算出的数值输入f(n)，以此类推。在不断映射的过程中，我们可以得到一个类似链表结构的序列。以 nums[2, 3, 1]为例，序列为 `0 -> 2 -> 1 -> 3`。 

* 如果nums中是没有重复的，当进行到某一步时，会有下标超出边界。
* 如果像本题一样，nums中存在重复元素，且nums每一个元素都在区间[1, n]内（元素取值在[1, n]内是为了保证环路不会因为下标越界而被隐藏），必然可以在序列中找到环路。

【证明环路存在】
如果 m -> t，n -> t，不妨设假设在映射过程中首先会找到m。 在序列中必定存在一条路径使得t能够经过若干次映射找到n，即 t -> x1 -> x2 -> ... -> n。此时，

![环路](https://i.loli.net/2018/10/30/5bd81c4d1da11.jpg)

当我们能够确定在序列中必定可以找到环路时，就可以使用Floyd判圈算法来求解重复元素了。具体算法参见[Floyd判圈算法](https://zh.wikipedia.org/wiki/Floyd%E5%88%A4%E5%9C%88%E7%AE%97%E6%B3%95)。

``` java
class Solution {
    public int findDuplicate(int[] nums) {
			int fast = nums[nums[0]], slow = nums[0];
			while(fast != slow){
				fast = nums[nums[fast]];
				slow = nums[slow];
			}
			slow = 0;
			while(fast != slow){
				slow = nums[slow];
				fast = nums[fast];
			}
			return slow;
    }
}
```