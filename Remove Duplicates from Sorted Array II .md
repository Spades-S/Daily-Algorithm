### 080 Remove Duplicates from Sorted Array II

#### Problem

Given a sorted array *nums*, remove the duplicates [**in-place**](https://en.wikipedia.org/wiki/In-place_algorithm) such that duplicates appeared at most *twice* and return the new length.

Do not allocate extra space for another array, you must do this by **modifying the input array in-place** with O(1) extra memory.



#### Example

```
Given nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.

It doesn't matter what you leave beyond the returned length.
```

```
Given nums = [0,0,1,1,1,1,2,3,3],

Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.

It doesn't matter what values are set beyond the returned length.
```



####Solution

【分析】总的来说这题思路不复杂，判断条件：nums[i-1] == nums[i]，相等则说明第i个元素是应该被移除的。

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if(length <=2 ){
            return length;
        }
        int index = 2;
        for(int i = 2; i < length; i++){
            if(nums[i] != nums[index-2]){ 
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
```

在上述解法中，需要关注的 是 for 循环中的判断条件，`if(nums[i] != nums[index-2])`，这里用的是当前元素nums[i]和更新后的nums[index-2]是否相等。

这里没有使用`if(nums[i] != nums[i-2] )` 作为判断依据，我们来看一下原因：

```
nums = [1, 1, 1, 2, 2, 3, 3]
如果使用if(nums[i] != nums[i-2]) 作为判断依据：
当i = 2时，循环不会对数组做任何改变，
接着i = 3，此时 index = 2，nums[index] = nums[i], 循环执行后nums数组将变为 [1, 1, 2, 2, 2, 3, 3]，
如果接着使用 if(nums[i] != nums[i-2]) 作为判断依据，当 i = 4 时，会有 nums[i] == nums[i-2]，此时循环体依旧不用对数组nums做任何改变，而这就是问题所在，nums[2]是被我们由1修改为2的，并非是数组本身就如此。

而造成这种差异的根本原因在于i和index是不同步的，在找到重复出现2次以上的元素时，index保持不变，i自加，从而数组的第0-index位元素保存了nums提出"重复"的值，而第0-i位元素则不是。

我们要关注的是 当前出现的元素 和去重后的元素是否重复。 关键在于去重后！
```

