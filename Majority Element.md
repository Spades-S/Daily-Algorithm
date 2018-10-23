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

【优化】[摩尔投票算法](https://github.com/Spades-S/LEETCODE/blob/master/Majority%20Element.md#%E6%91%A9%E5%B0%94%E6%8A%95%E7%A5%A8%E7%AE%97%E6%B3%95) 题目中还有一个关键条件是我忽略掉的，Major Element 在数组中出现的次数超过了 n / 2，并且一定存在，所以可以利用如下方式寻找Major Element:

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



### 229 Majority Element II

#### Problem
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Note: The algorithm should run in linear time and in O(1) space.

#### Examples

```
Input: [3,2,3]
Output: [3]

```

```
Input: [1,1,1,3,3,2,2,2]
Output: [1,2]

```

#### Solution
【分析】看完有一个非常常规的想法，遍历数组，用HashMap存值以及出现次数，在对HashMap做循环，找到Majority Element，时间复杂度最大为 O(2n)，空间复杂度最大为O(n)。What a pity，不满足所要求的O(1)的空间复杂度。

【摩尔投票】本题适用摩尔投票算法。摩尔投票算法详情参见 [摩尔投票算法](https://github.com/Spades-S/LEETCODE/blob/master/Majority%20Element.md#%E6%91%A9%E5%B0%94%E6%8A%95%E7%A5%A8%E7%AE%97%E6%B3%95)。本题实质上是摩尔投票的一个变种，摩尔投票要求 Majority Element 出现次数要大于 n/2，而本题是 n/3，在选择元组时要从二元组变为三元组。

``` java
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        int len = nums.length;
        if(len < 1){
            return res;
        }
        int candidateA = nums[0], candidateB = nums[0], cntA = 0, cntB = 0;
        for(int i = 0; i < len; i++){
            if(nums[i] == candidateA){
                cntA++;
                continue;
            }
            if(nums[i] == candidateB){
                cntB++;
                continue;
            }
            if(cntA == 0){
                candidateA = nums[i];
                cntA++;
                continue;
            }
            if(cntB == 0){
                candidateB = nums[i];
                cntB++;
                continue;
            }
            cntA--;
            cntB--;
        }
        cntA = 0;
        cntB = 0;
        for(int i = 0; i < len; i++){
            if(nums[i] == candidateA){
                cntA++;
            }else if(nums[i] == candidateB){
                cntB++;
            }
        }
        if(cntA > len/3){
            res.add(candidateA);
        }
        if(cntB > len/3){
            res.add(candidateB);
        }
        
        return res;
    }
}
```




### 摩尔投票算法

【基本思想】每次从序列中选择两个不相同的数字，将其删除掉（或称为“抵消”），重复该过程，如果序列中存在Majority Element，那么最后剩下的一个数字或者几个相同的数字就是出现次数大于总数一半的那个，即Majority Element。如果不存在，则将返回任意一个元素，**所以在第一次循环得到可能的Majority Element后，需要再次遍历确定该元素是不是Majority Element。**

【理解】我们可以这么理解摩尔投票算法，每次从序列中拿出一个二元组，这个二元组需要满足其中的两个元素不相同，Majority Element 在剩下的序列中一定还是 Majority，循环该过程，最终序列中将只剩下Majority Element。

以[1, 1, 1, 1, 1, 2, 3, 4]为例，容易知道这个序列中的Majority Element是 1：

|二元组类型|二元组|剩余序列| 剩余序列中的Majority Element|
|:---|:---|:----|:---|
|含有Majority Element |[1, 2]| [1, 1, 1, 1, 3, 4]| 1|
|不含有Majority Element | [2 ,3] | [1, 1, 1, 1, 1, 4] | 1 |

不论上述哪种方式选择二元组，最终剩下的序列中将只剩下元素 `1` 。

