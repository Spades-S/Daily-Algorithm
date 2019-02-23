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
					str.append(quo);
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