/**
 * @param {number} n
 * @return {number}
 */
var numTrees = function(n) {
    const res = [1];
    for(let i = 0; i <= n; i++){
        let temp = 0;
        for(let j = 0; j <= i; j++){
            temp += res[j]*res[i - j];
        }
        res.push(temp);
    }
    return res[n];
};