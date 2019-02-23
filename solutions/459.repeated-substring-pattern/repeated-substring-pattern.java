class Solution {
 public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for(int i = 1, j = (int) Math.sqrt(n); i <= j; ++i) {
            if (n % i == 0) { // i is a factor of n.
                // check both i and n/i. when i == 1, n/i == n.
                if (helper(s, i, n) || helper(s, n/i, n)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    static boolean helper(String s, int i, int n) {
        if (i > n/2) { // must repeat multiple times.
            return false;
        }
        // 1 <= i <= n/2.
        // 12345
        // 2345
        // if we can show 1234==2345, we have 1==2,2==3,3==4,4==5.
        return s.startsWith(s.substring(i));
    }
}