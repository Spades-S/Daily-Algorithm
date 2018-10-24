### 228 Summary Ranges

#### Problem
Given a sorted integer array without duplicates, return the summary of its ranges.

#### Examples

```
Input:  [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.

```

```
Input:  [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.

```

#### Solution
【分析】这道题比较简单，两个指针left、right，初始值均为0，遍历数组，如果当前元素和前一个元素相差1，right递增；如果当前元素和前一个元素相差不为1，更新left、right，均更新为当前索引，直到数组遍历结束。
 
```  java
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        if(nums.length < 1) return res; // 由于return之前可能会取到nums[0]，所以需要先排除nums为空的情况
        
        int start = 0, end = 0;
      
        for(int i = 1; i < nums.length; i++){
            if(nums[i] - nums[i-1] == 1){
                end ++;
            }else{
                res.add(start == end ? ""+nums[start] : nums[start] + "->" + nums[end]);
                start =  i;
                end = i;
            }
        }
        res.add(start == end ? ""+nums[start] : nums[start] + "->" + nums[end]);  //添加最后一段 Range
        return res;
    }
}
```

