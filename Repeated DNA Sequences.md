### 187 Repeated DNA Sequences

#### Problem
All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

#### Example
```
Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"

Output: ["AAAAACCCCC", "CCCCCAAAAA"]

``` 

#### Solution
【分析】本题属于常规题。

``` java	
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
			List<String> list = new ArrayList<String>();
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			for(int i = 0; i <= s.length() - 10; i++){
				String substr = s.substring(i, i + 10);
				int cnt = map.getOrDefault(substr, 0);
				if(cnt == 1) list.add(substr);
				map.put(substr, cnt + 1);
			} 
			return list;
    }
}

```

【优化】

``` java
class Solution {
	public List<String> findRepeatedDnaSequences(String s){
		HashSet<String> set = new HashSet<String>();
		HashSet<String> repeat = new HashSet<String>();
		for(int i = 0; i <= s.length() - 10; i++){
			String substr = s.substring(i, i + 10);
			if(!set.add(substr)){
				repeat.add(substr);
			}
		}
		return new ArrayList(repeat);
	}
}
```
这种方式巧妙地利用了HashSet.add方法的一个特点，当HashSet中已有带添加元素时，add方法会返回false。相比于前一种方法，该方法在每次循环时只需要操作HashTable两次，而前一种方式需要操作HashTable两次，ArrayList一次。