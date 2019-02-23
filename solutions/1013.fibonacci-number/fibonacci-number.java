class Solution {
    public int fib(int N) {
        if(N < 0) return -1;
        if(N == 0) return 0;
        if(N == 1) return 1;
        int[] store = new int[N + 1];
        store[0] = 0;
        store[1] = 1;
        for(int i = 2; i <= N; i++){
            store[i] = store[i - 1] + store[i - 2];
        }
        return store[N];
        
    }
}