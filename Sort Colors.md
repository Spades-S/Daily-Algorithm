### 075

#### Problem

Given an array with *n* objects colored red, white or blue, sort them **in-place **so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

**Note:** You are not suppose to use the library's sort function for this problem.

#### Example

```
Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
```

#### Solutions

【分析】这道题其实很简单，写这道题的本意就是练习插入排序。

【插入排序】通过构建有序序列，对于未排序数据，在已排序数据中从后向前扫描，找到相应的位置插入。

【插入排序步骤】

    1. 从第一个元素开始，该元素可以认为已经被排序
    2. 取出下一个元素，在已经排序的元素序列中从后向前扫描，
    3. 如果该元素(已排序)大于新元素，将该元素移动到下一位置
    4. 重复步骤3，直到已排序的元素小于或者等于新元素的位置
    5. 将新元素插入到该位置
    6. 重复步骤2-5

```java
class Solution {
    public void sortColors(int[] nums) {
        // 插入排序
        int length = nums.length;
        for(int i = 1; i< length; i++){
            int temp = nums[i]; // 需要保存i位置的值，在后面比较排序元素和新元素时，i位置处的值会被修改
            int j = i-1;
            for(;j>=0 && nums[j]>temp;j--){
                nums[j+1] = nums[j];
            }
            nums[j+1] = temp;
        }
    }
}
```

