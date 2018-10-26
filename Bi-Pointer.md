
### 026 Remove Duplicates from Sorted Array

#### Problem
Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

#### Examples
```
Given nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.

It doesn't matter what you leave beyond the returned length.

```

```
Given nums = [0,0,1,1,1,2,2,3,3,4],

Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.

It doesn't matter what values are set beyond the returned length.

```

#### Solution
【分析】这道题本质是将数组中非重复部分放到数组头部，要求在原地完成，且空间复杂度为O(1)。
【快慢指针】设置两个指针，初始指向同一个元素，当快慢指针指向相同元素时，快指针加一；当两个指针指向不同元素时，快慢指针均加一。
``` java 

class Solution {
    public int removeDuplicates(int[] nums) {
        int counter = 0; //counter 为慢指针
        for(int i=0;i<nums.length;i++){ // i 为快指针
            if(i==0 || nums[i]!=nums[counter-1]){
                nums[counter]=nums[i];
                counter++;
            }
        }
        return counter;
    }
}

```


### 080 Remove Duplicates from Sorted Array II

#### Problem
Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

#### Examples
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

#### Solutions

【分析】本题和 `26` 的区别在于，数组中可以有重复元素，但是最多可以重复一次，即在数组中最多有两个相同元素。本题依旧可以通过快慢指针的方式解决。区别在于判断条件由 `nums[counter - 1] != nums[i]`变为 `nums[counter - 2] != nums[i]`。

【快慢指针】

``` java
class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(len <=2 ) return len;
        int counter = 2;
        for(int i = 2; i < len; i++){
            if(nums[counter - 2] != nums[i]){
                nums[counter] = nums[i];
                counter++;
            }
        }
        return counter;
    }
}
```

在上述解法中，需要关注的 是 for 循环中的判断条件，`if(nums[i] != nums[counter-2])`，这里用的是当前元素nums[i]和更新后的nums[counter-2]是否相等。

这里没有使用`if(nums[i] != nums[i-2] )` 作为判断依据，我们来看一下原因：

```
nums = [1, 1, 1, 2, 2, 3, 3]
如果使用if(nums[i] != nums[i-2]) 作为判断依据：
当i = 2时，循环不会对数组做任何改变，
接着i = 3，此时 counter = 2，nums[counter] = nums[i], 循环执行后nums数组将变为 [1, 1, 2, 2, 2, 3, 3]，
如果接着使用 if(nums[i] != nums[i-2]) 作为判断依据，当 i = 4 时，会有 nums[i] == nums[i-2]，此时循环体依旧不用对数组nums做任何改变，而这就是问题所在，nums[2]是被我们由1修改为2的，并非是数组本身就如此。

而造成这种差异的根本原因在于i和counter是不同步的，在找到重复出现2次以上的元素时，counter保持不变，i自加，从而数组的第0 - counter-1位元素保存了nums去除"重复"的值，而第0-i位元素则不是。

我们要关注的是 当前出现的元素 和去重后的元素是否重复。 关键在于去重后！
```

### 283 Move Zeroes

#### Problem
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

#### Example
```
Input: [0,1,0,3,12]
Output: [1,3,12,0,0]

```

#### Note
You must do this in-place without making a copy of the array.
Minimize the total number of operations.


#### Solution
【分析】 这道题依旧可以通过快慢指针的方式来做。通过快慢指针可以将所有的非零元素放到数组头部，并且可以知道非零元素个数，从而可以计算出零元素个数，从数组末尾开始往里添加零元素。
【快慢指针】
``` java 
class Solution {
    public void moveZeroes(int[] nums) {
        int cnt = 0, len = nums.length;
        for(int i = 0; i < len; i++){
            if(nums[i] != 0){
                nums[cnt] = nums[i];
                cnt++;
            }
        }
        for(int i = 0; i < len - cnt; i++){
            nums[len - 1 - i] = 0;
        }
    }
}
```