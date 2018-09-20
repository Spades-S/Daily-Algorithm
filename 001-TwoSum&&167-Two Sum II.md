###001  Two Sum

####Problem

Given an array of integers, return **indices** of the two numbers such that they add up to a specific target.

You may assume that each input would have **exactly** one solution, and you may not use the *same* element twice.

####Example

```
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
```



#### Solution

```java
class Solution{
  public int[] twoSum(int[] nums, int target){
    int length = nums.length();
    Map<Integer, Integer> save = new HashMap<>();
    int[] result = null;
    for(int i =0;i<length;i++){
      int another = target - nums[i];
      if(save.containsKey(another)>-1){
        	result = new int[]{save.get(another),i};
        	break;
		}
      save.put(nums[i],i);
    }
    return null;
  }
}
```

这种算法的好处在于，只需要进行一次遍历。每次遍历会将遍历元素存到一个Map对象里保存起来，拿到新的元素，判断能否在之前遍历的数组中找到某个元素，使其相加为target。



-----------------------------------------------------------------------------------------------------------------------------------------------------------



### 167 Two Sum II



#### Problem 

Given an array of integers that is already **sorted in ascending order**, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

**Note:**

- Your returned answers (both index1 and index2) are not zero-based.
- You may assume that each input would have *exactly* one solution and you may not use the *same* element twice.

#### Example

```
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
```

#### Solution

【分析】对比下 **Two Sum** 和**Two Sum II**有何不同：相比于**Two Sum**，**Two Sum II**是排好序的，要求返回的index 不是基于0 的。就是这两点不同。

对于**Two Sum**，由于数组是无序的，在实现的时候最好的方式就是用HashMap去做记录，以降低时间复杂度。而对于**Two Sum II**，此时数组是有序的，并且顺序还是已知的，升序，我们可以利用两个游标，start 和 end，根据numbers[start] + numbers[end] 和 target 的大小关系 移动游标：`大于target，将end减小；小于target，增大start`，直到找到结果。

```java
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0, end = numbers.length - 1;
        while(start < end){
            if(numbers[start] + numbers[end] == target){
                return new int[]{start + 1, end + 1};
            }else if(numbers[start] + numbers[end] > target){
                end--;
            }else{
                start++;
            }
        }
        return new int[2];
    }
}
```







