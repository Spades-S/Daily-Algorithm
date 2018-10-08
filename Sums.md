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



### 015 3Sum

#### Problem

Given an array `nums` of *n* integers, are there elements *a*, *b*, *c* in `nums` such that *a* + *b* + *c* = 0? Find all unique triplets in the array which gives the sum of zero.

#### Example

```
Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
```



#### Solutions

#### Mine

我上来就是Brute force，在3维度上没有想到特别好的优化方法，就直接尝试暴力解法，不出意外地TLE了。然后。。。很不要脸地去看了别人的解答。

#### Optimize

```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        if(length<3){
            return result;
        }
        List<Integer> beforeItem = new ArrayList<Integer>();
        Arrays.sort(nums);
        
        for(int i = 0;i<length-2;i++){
            if(i>0 && nums[i-1]==nums[i]) continue;
            result.addAll(twoSum(nums,i,length));
        }
        return result;
    }
    private List<List<Integer>> twoSum(int[] nums,int i,int length){
        List<List<Integer>> res = new ArrayList<>();
        int target = 0 - nums[i], start=i+1, end=nums.length-1;
        while(start<end){
            if(nums[start] + nums[end] == target){
                List<Integer> item = new ArrayList<Integer>();
                item.add(nums[i]);
                item.add(nums[start]);
                item.add(nums[end]);
                res.add(item);
                do{
                    start ++;
                }while(nums[start]==nums[start-1] && start<length-1);
                do{
                    end --;
                }while(nums[end] == nums[end+1] && end > start);
            }else if(nums[start]+nums[end]>target){
                end --;
            }else{
                start++;
            }
        }
        return res;
    }
```

这种做法和蛮力法的区别在于，将三维的降低到了两维，对于2Sum这个的优化方法是很常见的。通过将3Sum转化为2Sum，并在2Sum上做优化，以此来降低整个3Sum算法的复杂度。



#### Summary

对于3Sum、4Sum这种高于“两维”的问题，应该通过一层一层“降维”的方式将其转化为2Sum，在2Sum上进行优化。“降维”的方式为后面的`3Sum Closest`  和  `4Sum`  提供了思路。



### 018 4Sum

#### Problem

Given an array `nums` of *n* integers and an integer `target`, are there elements *a*, *b*, *c*, and *d* in `nums` such that *a* + *b* + *c* + *d* = `target`? Find all unique quadruplets in the array which gives the sum of `target`.

#### Example

```
Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
```



#### Solutions

#### Mine

```java
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            result.addAll(threeSum(nums,i,target));
        }
        return result;
    }
    private List<List<Integer>> threeSum(int[] nums,int i, int target){
        List<List<Integer>> result = new ArrayList<>();
        for(int j = i+1;j<nums.length-2;j++){
            if(j>i+1 && nums[j]==nums[j-1]) continue;
            result.addAll(twoSum(nums, i, j, target));
        }
        return result;
    }
    private List<List<Integer>> twoSum(int[] nums, int i, int j, int target){
        int start = j + 1, end = nums.length - 1;
        List<List<Integer>> result = new ArrayList<>();
        while(start<end){
            if(nums[i] + nums[j] + nums[start] + nums[end] == target){
                List<Integer> item = Arrays.asList(nums[i], nums[j], nums[start], nums[end]);
                result.add(item);
                 do{
                    end--;
                }while(nums[end]==nums[end+1] && end > start);
                 do{
                    start++;
                }while(nums[start]==nums[start-1] && start< nums.length-1);
            }else if(nums[i] + nums[j] + nums[start] + nums[end] > target){
                do{
                    end--;
                }while(nums[end]==nums[end+1] && end > start);
            }else{
                do{
                    start++;
                }while(nums[start]==nums[start-1] && start< nums.length-1);
            }
        }
        return result;
    } 
}
```

本算法的时间复杂度是O(n^3)。本算法核心在于将4Sum转化到3Sum进而到2Sum，对2Sum进行优化，将2Sum的事件复杂度由O(n^2)降低到O(n)。如果不进行“降维”，直接从4Sum出发考虑这个问题，是不太好进行优化的，至少我是没有想到的。

#### Optimize

看了下runtime很少的方法，是对特定情况做了过滤，一次减少threeSum、twoSum被执行的次数，进而达到优化的目的。方法上没有特殊的地方。

#### Summary

对于4Sum这种高于“两维”的问题，应该通过一层一层“降维”的方式将其转化为2Sum，在2Sum上进行优化。







