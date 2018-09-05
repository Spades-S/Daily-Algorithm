#### Problem

Given a string `S`, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.

If possible, output any possible result.  If not possible, return the empty string.

#### Example

```
Input: S = "aab"
Output: "aba"
```

```
Input: S = "aaab"
Output: ""
```



#### Solutions

【分析】这道题大体的思路还是有的。首先将字符及其出现的次数拿到，然后判断存在满足条件的字符串，如果存在，利用字符及其出现的次数拼接新字符串使其满足题目要求。

【Step 1】需要将字符及其出现的次数拿到，可以利用HashMap去记录，这个过程很容易，遍历字符串，更新字符出现的次数即可。

【Step 2】判断是否存在满足题目条件的字符串，这个判断条件不难找到：`如果存在某个字符出现次数大于(n+1)/2，则不存在符合条件的字符串。`

【Step 3】拿到了字符及其出现次数之后，就是拼接题目要求的字符串了。这是比较困难的一个过程，至少对我而言非常困难，我就是死在了这一步上。

-----------------------------------------------------------------------------------------------------------------------------------------------------------

【关键内容】如何利用字符串和其出现次数去拼接一个相同字符不相邻的字符串，这次字符满足条件：出现次数小于 ` (字符串长度+1)/2`。Solution里给出了一种做法，[是的，你没有看出，这道题我又是看了solution]，从第二个位置开始，步长为2更新字符串，当到达字符串末尾时，回到第一个位置，依旧以2为步长更新字符串。

这是一个很牛批的做法。

在第一轮更新过程中（从第二个位置开始，步长为2，直到字符串末尾），至少更新了`字符串长度/2` 个 字符，单个字符最多可能出现`(字符串长度+1)/2` 次，也就是说在第一轮更新之后，出现次数最多的字符最多剩下一个，而这个将会被放在第一个位置，此时第一个位置和第二个位置出现相同字符串，所以在第一轮更新的时候要先更新出现次数少的字符，这样相同的字符都会被隔开。

```java
class Solution {
    public String reorganizeString(String S) {
        int length = S.length();
        if(length<=1){
            return S;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        ArrayList<Character> list = new ArrayList<Character>();
        
        for(int i = 0; i < length; i++){
            Character c = new Character(S.charAt(i));
            if(list.contains(c)){
                int value = map.get(c) + 1;
                if(value > (length+1)/2){
                    return "";
                }
                map.put(c, map.get(c)+1);
            }else{
                map.put(c, 1);
                list.add(c);
            }
        }
        return helper(list, map, length);
    }
    
    public String helper(ArrayList<Character> list, HashMap<Character, Integer> map, int length){
        char[] res = new char[length];
        list.sort(new Comparator<Character>(){
            @Override
            public int compare(Character c1, Character c2){
                return map.get(c1) - map.get(c2);
            }
        });
        Character c = list.get(0);
        list.remove(0);
        int counter = 0, index=1;
        while(counter<length){
            if(index>=length){
                index=0;
            }
            if(map.get(c)==0){
                c = list.get(0);
                list.remove(0);
            }
            res[index] = c;
            map.put(c, map.get(c)-1);
            index += 2;
            counter++;
        }
        return String.valueOf(res);
        
    }
}
```



