/**
 * @param {number} n
 * @return {string}
 */
var countAndSay = function(n) {
    const res = ['1'];
    for(let i = 1; i < n; i++){
        res.push(helper(res[i -1]));
    }
    return res[n - 1];
    
    function helper(str){
        let res = '';
        let cnt = 0;
        for(let i = 0; i < str.length; i++){
            if(i > 0 && str[i] !== str[i - 1]){
                res += cnt + str[i - 1];
                cnt = 0;
            }
            cnt++;
        }
        res += cnt + str[str.length - 1];
        return res;
    }
    
};