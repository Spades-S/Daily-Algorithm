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