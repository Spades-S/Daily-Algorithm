### 136 Single Number

#### Problem

Given a non-empty array of integers, every element appears twice except for one. Find that single one.

#### Note

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

#### Example

```
Input: [2,2,1]
Output: 1
```

```
Input: [4,1,2,1,2]
Output: 4
```

#### Solution

【分析】看完题目最先想到的是异或，题目中说了除了一个元素只出现了一次之外，其他的元素都出现了两次。 a^a^b = b。使用异或可以不适用额外的空间。

```java
class Solution {
    public int singleNumber(int[] nums) {
			int res = 0;  // 0 ^ a = a
			for(int num : nums){
				res ^= num;
			}
			return res;
    }
}

```

【HashTable】本题的标签是 HashTable，也就是说本题可以使用 HashTable 来解答。判断当前元素是否在HashSet中，如果在，移除该元素，否则将其加入HashSet，最终HashSet中将只剩下所求元素。

```java
class Solution{
	public int singleNumber(int[] nums){
		HashSet<Integer> set = new HashSet<Integer>();
		for(int num : nums){
			if(!set.add(num)){
				set.remove(num);
			}
		}
		return set.iterator().next();
	}
}
```
