#### Problem

Given a string **s**, find the longest palindromic substring in **s**. You may assume that the maximum length of **s** is 10

#### Example

```
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
```

```
Input: "cbbd"
Output: "bb"
```



#### Solution

【分析】回文字符串最大的特征在于对称，解决问题的方法也可以从其特征中进行寻找。**中心点**，首先寻找到确定一个中心点，然后向两边进行扩散，直到中心点两侧的字符不再对称为止。

**一个长度为n的字符串，中心点有2n-1种情况。**

n个中心点应该是容易想到的，也就是字符串中的n个字符，这个时候默认了回文子串长度为奇数。

剩余的n-1个中心点，是对应的回文子串为偶数长度的情况。这个时候中心点应该是处在字符串中两个相邻字符中间空白的地方。即回文字符串`abba`中心点是`bb`中间的空白。

```java
// 这是solution提供的解答，代码很清晰，比我自己的解答好很多，思路基本一致，不过我的解答上面贴了好多补丁
class Solution {
    public String longestPalindrome(String s) {
      int start = 0, end = 0;
      for (int i = 0; i < s.length(); i++) {
          int len1 = expandAroundCenter(s, i, i);
          int len2 = expandAroundCenter(s, i, i + 1);
          int len = Math.max(len1, len2);
          if (len > end - start) {
              start = i - (len - 1) / 2;
              end = i + len / 2;
          }
      }
      return s.substring(start, end + 1);
  }

  private int expandAroundCenter(String s, int left, int right) {
      int L = left, R = right;
      while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
          L--;
          R++;
      }
      return R - L - 1;
  }
}
```











