/**
 * @param {number} N
 * @return {number}
 */
var fib = function(N) {
    if(N < 0) return -1;
    const store = new Array(N + 1);
    store[0] = 0;
    store[1] = 1;
    for(let i = 2; i <= N; i++){
        store[i] = store[i - 1] + store[i - 2];
    }
    return store[N];
};