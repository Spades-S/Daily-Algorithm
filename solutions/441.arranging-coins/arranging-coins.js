/**
 * @param {number} n
 * @return {number}
 */
var arrangeCoins = function(n) {
    return Math.floor((-1 + Math.sqrt(1 + 8*n))/2);
};