/**
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
var uniquePaths = function(m, n) {
    const res = new Array(n);
    for(let i = 0; i < n; i++){
        res[i] = new Array(m);
        res[i].fill(1);
    }
    for(let i = 1; i < n; i++){
        for(let j = 1; j < m; j++){
            res[i][j] = res[i - 1][j] + res[i][j -1];
        }
    }
    
    return res[n - 1][m - 1];
    
};