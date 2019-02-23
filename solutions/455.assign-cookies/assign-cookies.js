/**
 * @param {number[]} g
 * @param {number[]} s
 * @return {number}
 */
var findContentChildren = function(g, s) {
    let res = 0;
    g.sort((a, b) => b - a);
    s.sort((a, b) => b - a);
    let index = 0; 
    for(let i = 0; i < g.length; i++){
        if(index >= s.length){
            return res;
        }
        if(g[i] <= s[index]){
            res++;
            index++;
        }
    }
    return res;
};