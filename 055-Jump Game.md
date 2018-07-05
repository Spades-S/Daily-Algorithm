#### Problem

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

#### Example

```
Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
```

```
Input: [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum
             jump length is 0, which makes it impossible to reach the last index.
```



#### Solutions

【分析】solution里给的几种方法都不是很好。我想出的这个方法应该算是比较好的了。我们来观察一下，在什么情况下有可能到达不了终点？在第0-第length-2个元素中有值为0的元素，那么将会有可能到达不了终点。记值为0的元素的索引为P_Zero，如果在第0-第P_Zero-1个元素中，不存在元素m使得m的值>P_zero - M的索引，那么将永远无法到达终点。

```java
class Solution {
    public boolean canJump(int[] nums) {
        boolean canReach = true; 
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == 0){
                canReach = false; // 这个时候可能无法达到终点
                int j = i - 1;
                while(j>=0){ 
                    if(nums[j] > i - j){ // 看是否存在元素j使得nums[j] > i - j，如果存在则可达到终点
                        canReach = true;
                        break;
                    }
                    j--;
                }
                if(!canReach){ // 当0值元素向左查找结束之后不存在j使得nums[j] > i - j，则无论从哪个点开始最终都将落到0值元素，也将永远无法到达之中
                    break;
                }
            }
        }
        return canReach;
        
    }
}
```



