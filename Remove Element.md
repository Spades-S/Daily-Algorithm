### 027
#### Problem

Given an array *nums* and a value *val*, remove all instances of that value [**in-place**](https://en.wikipedia.org/wiki/In-place_algorithm) and return the new length.

Do not allocate extra space for another array, you must do this by **modifying the input array in-place** with O(1) extra memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

#### Example

```
Example 1:

Given nums = [3,2,2,3], val = 3,

Your function should return length = 2, with the first two elements of nums being 2.

It doesn't matter what you leave beyond the returned length.
```
```
Example 2:

Given nums = [0,1,2,2,3,0,4,2], val = 2,

Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.

Note that the order of those five elements can be arbitrary.

It doesn't matter what values are set beyond the returned length.
```



#### Solutions

#### Mine

```java
class Solution {
    public int removeElement(int[] nums, int val) {
        int result=0,dStart=-1;
        Arrays.sort(nums);
        for(int i = 0;i<nums.length;i++){
            if(nums[i]!= val){
                result++;
            }else if(dStart == -1){
                dStart = i;
            }
        }
        int dLength = nums.length -result;
        if(dLength>0){
            for(int i = 0;i<dLength;i++){
                if(nums.length-1-i>dStart+dLength-1){
                    nums[dStart+i] = nums[nums.length-1-i];
                }else{
                    break;    
                }
            }
        }
        return result;
    }
}
```

本算法的时间复杂度是O(2n)。首先遍历去寻找val值数目，然后更新数组，更新数组的方式为：从最后一个item开始拿，将其填充到val值处，直到`nums.length-1-i>dStart+dLength-1` 。这个方法虽在在本题中没有什么优势，但是还是有一定的可取性的，亮点在于**从最后一个item开始拿，将其填充到val值处**。

#### Optimize

```java
class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int begin=0;
        for(int i=0;i<n;i++)
            if(nums[i]!=val)
                nums[begin++]=nums[i];
        return begin;
    }
}
```

优化的方法就很简单了，在计算val值长度的同时更新数组。

#### Summary

优化的方法一时没有想到，钻到死角里了。



