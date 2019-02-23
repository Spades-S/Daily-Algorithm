/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function(n) {
    const store = [1, 2];
    for(let i = 2; i < n; i++){
        const item = store[i - 1] + store[i - 2];
        store.push(item);
    }
    return store[n -1];
};