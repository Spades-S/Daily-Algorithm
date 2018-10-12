### 169 Majority Element


#### Problem
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

#### Examples
```
Input: [3,2,3]
Output: 3
```

```
Input: [2,2,1,1,1,2,2]
Output: 2
```

#### Solution
【分析】看完这道题我首先想到的是 `Tow Sum` 中采用的HashMap方法，因为既要记录某个元素出现的次数，又要记录下该元素的值，用HashMap可能会好一点

HashMap思路：
``` java
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
            }else{
                map.put(nums[i], 1);
            }
        }
        int res = nums[0];
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            res = entry.getValue() > map.get(res) ? entry.getKey() : res;
        }
        return res;
    }
}

```

看了下运行结果，发现只击败了24 percent，说明还有很大的优化空间。

【优化】题目中还有一个关键条件是我忽略掉的，Major Element 在数组中出现的次数超过了 n / 2，并且一定存在，所以可以利用如下方式寻找Major Element:

``` java
class Solution {
    public int majorityElement(int[] nums) {
        int major = nums[0], count = 0;
        for(int i = 0; i < nums.length; i++){
            if(count == 0){
                count++;
                major = nums[i];
            }else if(nums[i] == major){
                count++;
            }else{
                count--;
            }
        }
        return major;
    }
}

```
该方法首先假设当前元素为Major Element，看下一个元素是否和当前Major Element一致，如果一致计数加一，否则减一，当计数值为0时，说明当前元素一定不是Major Element，则修改 Major Element。

为什么说当计数为0时，可以确定当前元素一定不是Major Element？

因为Major Element出现次数是比其他所有元素加起来都多的，不可能出现Major Element 计数值为0的情况。