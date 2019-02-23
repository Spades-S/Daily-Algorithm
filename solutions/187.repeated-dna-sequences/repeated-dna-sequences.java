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