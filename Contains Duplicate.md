### 217 Contains Duplicate

#### Problem
Given an array of integers, find if the array contains any duplicates.

Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

#### Examples
```
Input: [1,2,3,1]
Output: true

```

```
Input: [1,2,3,4]
Output: false

```

```
Input: [1,1,1,3,3,4,3,2,4,2]
Output: true

```

#### Solution
【分析】本题只需要知道有没有重复，使用HashSet就可以解决问题。
【HashSet】
``` java
class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums.length < 2) return false;
        HashSet<Integer> set = new HashSet<Integer>();
        for(int num : nums){
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }
        return false;
    }
}

```

【先排序】
``` java

class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums.length < 2) return false;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == nums[i+1]) return true;
        }
        return false;
    }
}

```


### 219 Contains Duplicate II

#### Problem
Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

#### Examples
```
Input: nums = [1,2,3,1], k = 3
Output: true
```

```
Input: nums = [1,0,1,1], k = 1
Output: true
```

```
Input: nums = [1,2,3,1,2,3], k = 2
Output: false
```


#### Solution
【分析】这题和 `217` 的不同在于，当找到重复元素之后需要判断重复元素之间的距离是否是小于给定的值，所以对于本题来说要使用HashMap，记录值和索引。

【HashMap】
``` java
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i]) && i - map.get(nums[i]) <= k){ // 当出现重复元素且满足距离小于定值时返回true
                return true;
            }
            map.put(nums[i], i); //否则都需要更新HashMap，因为如果重复元素不满足距离要求，当下次再找到相同元素时，应该计算和本次找到的值间的距离
        }
        return false;
    }
}

```

【维护定长HashSet】

``` java 
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i - 1 - k]);  // 维护了定长HashSet
            if(!set.add(nums[i])) return true;
        }
        return false;
    }
}
```

