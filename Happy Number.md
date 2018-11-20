### 202 Happy Number

#### Problem
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

#### Example
```
Input: 19
Output: true
Explanation: 
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
```


#### Solution
【分析】本题属于常规题。

``` java

class Solution {
    public boolean isHappy(int n) {
			HashSet<Integer> set = new HashSet<Integer>();
			while(set.add(n)){
				n = helper(n);
				if(n == 1) return true;
			}
			return false;
    }
		public int helper(int n){
			int res = 0;
			while(n != 0){
				int rem = n % 10;
				res += rem * rem;
				n = n / 10;
			}
			return res;
		}
}

```