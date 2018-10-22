### 189 Rotated Array

#### Problem
Given an array, rotate the array to the right by k steps, where k is non-negative.

#### Examples
```
Example 1:

Input: [1,2,3,4,5,6,7] and k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

```

```
Input: [-1,-100,3,99] and k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]

```

#### Solution
【分析】这道题想找一个解决方法很容易。
【方法一】移动数组元素: 先将要移动到数组开头的 K%nums.length 个元素放到一个新数组中，然后就是将nums中各个值移动到该有的位置。
``` java
class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        if(k > 0){
            int[] temp = new int[k];
            for(int i = 0; i < k; i++){
                temp[k - 1 -i] = nums[len - 1 -i];
            }
            for(int i = len - 1; i > k -1; i--){
                nums[i] = nums[i - k];
            }
            for(int i = 0; i < k; i++){
                nums[i] = temp[i];
            }
        }
        
    }
}
```

【方法二】翻转法，首先翻转整个数组，使得需要移动到数组开头的几个元素出现在数组开头，然后翻转0 - k%nums.length - 1 个元素，使得其符合移动顺序，最后将  k%nums.length - nums.length 元素恢复最开始的顺序。

``` java
class Solution{
	public void rotate(int[] nums, int k){
		int len = nums.length;
		k %= len;
		reverse(nums, 0, len -1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, len - 1);

	}
	public void reverse(int[] nums, int start, int end){
		while(start < end){
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			end--;
			start++;
		}
	}
}

```
