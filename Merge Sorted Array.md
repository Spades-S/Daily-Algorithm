### 088 Merge Sorted Array

#### Problem

Given two sorted integer arrays *nums1* and *nums2*, merge *nums2* into *nums1* as one sorted array.

**Note:**

- The number of elements initialized in *nums1* and *nums2* are *m* and *n* respectively.
- You may assume that *nums1* has enough space (size that is greater or equal to *m* + *n*) to hold additional elements from *nums2*.

 

#### Example

```
Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
```



#### Solution

【分析】这道题可以算是归并的一个子环节。在归并中merge两个已排序数组，常规操作：新建一个数组，从索引为0开始依次比较两个数组大小，将较小者放入新数组，直到两个数组遍历完成。用这种方式来处理这道题可以完成，但是性能上(尤其是体现在空间利用率上)相对较低。 

**我们需要注意，题目指明了nums1数组是足够长的，足以容纳下m+n个元素。也就是说完全是不用重新建立一个长度为m+n的数组的。**

在不新建数组的情况下，应该如何处理呢？

首先定义一个游标i，使其指向m+n-1，即m+n个数里最大的那个数所在的位置，从后向前遍历nums1和nums2，nums1从m-1处开始遍历，nums2从n-1处开始遍历，比较nums1和nums2中当前遍历到的元素大小，哪个大就放入nums1[i]中，同时在该数组上向前移动一位，并递减 i。

```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m+n-1;
        m -= 1;
        n -= 1;
        while(m>=0 && n>=0){
            if(nums1[m]<nums2[n]){
                nums1[index] = nums2[n];
                n--;
            }else{
                nums1[index] = nums1[m];
                m--;
            }
            index--;
        }
        while(n>=0){
            nums1[index] = nums2[n];
            index--;
            n--;
        }
    }
}
```

其实这个方法最妙的地方在于，当m和n都不小于0的时候需要比较nums1[m]和nums2[n]的大小，将两者中大的放入nums1[index]，如果m和n其中有一个小于0，也就是，nums1和nums2需要遍历的部分有一个已经遍历完成了，这个时候只需要看nums2是否遍历完成，如果没有，继续遍历：**上述情况对应着，nums1需要遍历的元素都已经重新排列好，当前位置相对开始的位置偏后，nums2 中剩下的都需要放在nums1数组的头部**。

这个地方有人可能会有疑问，为什么只检查 n是否不小于0，而不检查m呢？**当nums2需要遍历的元素都遍历完成，nums1里剩下的元素就是需要放在nums1头部的元素，而最开始这些元素就处在nums1头部，不需要调整位置。**



