####Problem

Given a string, find the length of the **longest substring** without repeating characters.

#### Example

Given `"abcabcbb"`, the answer is `"abc"`, which the length is 3.

Given `"bbbbb"`, the answer is `"b"`, with the length of 1.

Given `"pwwkew"`, the answer is `"wke"`, with the length of 3. Note that the answer must be a **substring**, `"pwke"` is a *subsequence*and not a substring.



#### Solutions

#### Mine

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int result = 0;
        if(length < 2){
            return length;
        }
        for(int i = 0;i<length-1;i++){
            for(int j = i+1;j<length;j++){
                int index = s.substring(i,j).indexOf(s.charAt(j));
                if(index>-1){
                    result = result>j-i?result:j-i;
                    i=i+index; // 优化点1
                    break;
                }else if(j==length-1){
                    result = result>length-i?result:length-i;
                }
            }
        }
        return result;
    }
}
```

本算法的时间复杂度是O(n^2)。本算法用的还是暴力遍历的思想，观察在增加一个字符串的情况下是否会出现重复，如果没有出现重复则不改变输出结果(result)，直到遍历到数组尾部(j == length-1)；如果有重复，判断当前不重复子字符串和result谁大，取其中较大值，同时滑动子字符串起始位置(i==i+index)，这个也是本算法唯一的两点，有点滑窗的意思了。

#### Optimize

我自己想出的算法被A了之后，看了下运行时间的排名，Your runtime beats 2.61% of java submissions。这个排名已经说明了我的那个算法其实不算好，算法能够解决问题，但是并不是那么优雅。

利用滑框去寻找最大子串。滑框初始宽度为零（滑框起始端和终止端都在字符串开始处），利用循环增加滑框宽度（滑框终止端右移），每次增加1。增加宽度时判断，当前新加入的字符是否和之前重复，如果重复，滑框起始端收缩到重复字符之后。在这个过程中，需要一个数组来保存各个字符如果出现重复对应的收缩长度，并且在每次在收缩之后需要更新数组对应的值。**整个收缩过程是不可逆的。也就是说滑框的起始端和终止端都只能够向右滑动**。

```java
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
          //如果有重复会更新i，实现起始端右移，滑框收缩，需要注意Math.max，这个说明收缩是不可逆的
            i = Math.max(index[s.charAt(j)], i); 
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;//每个字符对应的需要收缩的长度，遇到重复字符会更新
        }
        return ans;
    }
}
```



#### Summary

本题要求是最长不重复子串。要求是子串，也就是说，我们要得到的是一个有顺序的并且是连续的东西。如果不出现重复可以一直增长，一旦出现重复，必须将重复字符以及之前的东西全部丢掉，重新寻找，丢弃的同时记录下重复之前的子串长度，用于和后面发现的子串长度进行对比，留下较大值。

举个例子：

字符串为 ： qwabcdefamnts

在遇第二个`a`之前这个子串可以一直增长，一旦遇到第二个`a`，就得丢掉`qwa`，继续向下寻找。



