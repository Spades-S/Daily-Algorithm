class Solution {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        int cnt = 0;
        for(int i = 2; i < n; i++){
            if(!isPrime[i]) {
                cnt++;
                for(int j = 2; j*i < n; j++){
                    isPrime[i*j] = true;
                }
            }
        }
        return cnt;
    }
}