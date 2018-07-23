#### Problem

Given two strings *s* and *t *, write a function to determine if *t* is an anagram of *s*.

#### Example

```
Input: s = "anagram", t = "nagaram"
Output: true
```

```
Input: s = "rat", t = "car"
Output: false
```



#### Solutions

【分析】这题很容易。

【方法一】将s和t分别排序，比较排序后的字符串是否一致，如果一致，返回true，否则，false。

【方法二】用表格记录分别记录两个字符串中每个字符出现的频次，比较频次是否相等，相等则返回true，否则 	false。

```java
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) {
            return true;
        } else if (s == null || t == null) {
            return false;
        } else if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for(char c : s.toCharArray()){
            table[c-'a' ]++;
        }
        for(char c : t.toCharArray()){
            table[c - 'a']--;
        }
        for(int i = 0; i < table.length; i++){
            if(table[i]!=0){
                return false;
            }
        }
        return true;
    }
}
```



