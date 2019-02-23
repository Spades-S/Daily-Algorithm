class Solution {
    public String findLongestWord(String s, List<String> d) {
        String ans = "";
        
        for (String word : d) {
            if (check(s, word)) {
                if (word.length() > ans.length() || (word.length() == ans.length() && word.compareTo(ans) < 0))
                    ans = word;
            }
        }
        return ans;
    }
    
    private boolean check(String s, String target) {
		int start = -1;
		for (int i = 0; i < target.length(); i++) {
			int index = s.indexOf(target.charAt(i), start + 1);
			if (index == -1) {
				return false;
			}
			start = index;
		}
		return true;
	}
}