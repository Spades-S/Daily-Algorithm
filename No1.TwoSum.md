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

#### Mine

```Java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }
}
```

首先这是一个简单类型的题目，整个逻辑上没有很复杂。看到题目我最直接的想法就是两个for循环的嵌套，遍历每一个可能的nums[0]和nums[1]，看是否相等。

两层for嵌套，时间复杂度o(n^2)，没有很奇异想法，A了，时间大概是59ms。整个语法书写上可能会有问题，因为不是很熟悉java的语法。



#### Optimize

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







