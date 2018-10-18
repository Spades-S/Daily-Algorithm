### 179

#### Problem

Given a list of non negative integers, arrange them such that they form the largest number.

#### Example

```
Input: [10,2]
Output: "210"
```

```
Input: [3,30,34,5,9]
Output: "9534330"
```



#### Solutions

【分析】这道题的本质还是排序，核心问题在于两个数字如何拼接能达到最大值，这道题的解题思路很棒，**用字符串的形式将两种形式拼接出来，然后比较字符串，字符串是按照Ascall码表的前后顺序比较，其先后顺序和数字值的先后顺序一致。**

```java
class Solution {
    private class numComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2){
            return (s2 + s1).compareTo(s1 + s2);
        }
    }
    
    public String largestNumber(int[] nums) {
        String[] strArr = new String[nums.length];
        for(int i = 0; i < strArr.length; i++){
            strArr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strArr, new numComparator());
        if(strArr.length>0 && strArr[0].equals("0")){
            return "0";
        }
        StringBuilder result = new StringBuilder();
        for(String str : strArr){
            result.append(str);
        }
        return result.toString();
    }
}
```





