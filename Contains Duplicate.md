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


### 442 Find All Duplicates in an Array

#### Problem
Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

#### Example
```
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]

```

#### Solution
【分析】如果可以使用额外的空间，这题很容易做，利用HashSet判断当前元素是否是重复元素即可。
【HashSet】
``` java
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        HashSet<Integer> set = new HashSet<Integer>();
        for(int num : nums){
            if(set.contains(num)){
               res.add(num); 
            }else{
                set.add(num);
            }
        }
        return res;
    }
}
```

但是很不幸，不可以使用额外的存储空间。观察题目提供的条件，数组元素的取值范围是[1, n]，如果我们将元素值减一当做数组的index，即将a[i] - 1 当做index，并且改变nums[index]的符号，由正变为负，如果数组中有重复元素，那么当第二次找到重复元素时，此时的nums[index]必定为负。

``` java
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        for(int num : nums){
					int index = Math.abs(num) - 1; // 这里需要使用绝对值，因为index的获取应该是用原数组中元素的值，这里有可能是负数
					if(nums[index] < 0){
						res.add(index + 1);
					} 
					else{
						nums[index] = -nums[index];
					}
        }
        return res;
    }
}

```


### 448 Find All Numbers Disappeard in an Array

#### Problem
Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

#### Example
```
Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]

```

#### Solution
【分析】本题可以当做是 `442` 的“补集“，一个寻找重复元素，一个寻找缺失元素。按照 `442` 的思路，将nums[i] - 1 当做index，改变nums[index]的符号，对于重复出现的元素只改变其对应的nums[index]符号一次，再次遍历数组，值为正数的元素的索引加一即是缺失的元素。

``` java 

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
			List<Integer> res = new ArrayList<Integer>();
			for(int num : nums){
				int index = Math.abs(num) - 1;
				if(nums[index] > 0) nums[index] = - nums[index];
			}
			for(int i = 0; i < nums.length; i++){
				if(nums[i] > 0) res.add(i + 1);
			}
      return res;
    }
}

```

