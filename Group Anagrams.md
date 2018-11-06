### 049 Group Anagrams

#### Problem

Given an array of strings, group anagrams together.

#### Example

```
Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
```

#### Note

- All inputs will be in lowercase.
- The order of your output does not matter.

#### Solution

【分析】本题和一般的 HashTable 题的不同之处在于，要找的不是相同的元素，而是由相同字符构成但顺序不同的“异构”元素。我们知道利用 HashTable 去判断当前元素是否为重复元素，只能针对重复的元素，所以我们需要将“异构”元素转变为相同的元素。
【异构 -> 相同】我们知道本题中异构元素是指字符串中字符的顺序不同，那么怎么变为相同的呢？ 对字符串中的所有字符按照一定标准重新排序，即可将异构元素转换为相同的元素。
```java
char[] temp = str.toCharArray();
Arrays.sort(temp);// 按照字典顺序
String sorted = String.valueOf(temp);
```
--- 
``` java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        int len = strs.length;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i < len; i++){
            char[] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String sorted = String.valueOf(temp);
            if(map.containsKey(sorted)){
                int index = map.get(sorted);
                res.get(index).add(strs[i]);
            }else{
                List<String> list = new ArrayList<String>();
                list.add(strs[i]);
                map.put(sorted, res.size());
                res.add(list);
            }
        }
        return res;
    }
}
```


