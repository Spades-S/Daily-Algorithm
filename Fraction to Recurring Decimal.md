### 166 Fraction to Recurring Decimal

#### Problem
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

#### Examples
```
Input: numerator = 1, denominator = 2
Output: "0.5"
```

```
Input: numerator = 2, denominator = 1
Output: "2"
```

```
Input: numerator = 2, denominator = 3
Output: "0.(6)"
```

#### Solution
【分析】本题是要用String的形式来表示小数，如果是循环小数，则用括号将循环体包起来。本题关键在于判断循环体，循环体出现的标志是，当前余数和之前余数相等。当余数相同时，下一次相除的商和余数必然也相同，从而进入循环。

``` java
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
			if(numerator == 0) return "0";
			StringBuilder str = new StringBuilder();
			if(numerator < 0 ^ denominator < 0) str.append('-'); // 已经排除了numerator为0
			long nume = Math.abs((long) numerator);
			long deno = Math.abs((long) denominator); // 这里需要用long，防止当值为 Integer.MIN_VALUE 时，数据溢出
			long quo = nume / deno;
			long rem = nume % deno;
			str.append(quo);
			if(rem == 0) return str.toString();
			str.append('.');
			HashMap<Long, Integer> map = new HashMap<Long, Integer>();
			map.put(rem, str.length());
			while(rem != 0){
				quo = rem*10 / deno;
				rem = rem*10 % deno;
				str.append(quo); // 须将当次计算的商加入StringBuilder，即便是余数重复，循环体也是从下一次计算的商才开始
				if(map.containsKey(rem)){
					str.insert(map.get(rem), "(");
					str.append(')');
					break;
				}else{
					map.put(rem, str.length());
				}
			}
			return str.toString();
    }
}
```