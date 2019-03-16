/**
 * @param {string} s
 * @param {string[]} wordDict
 * @return {boolean}
 */
var wordBreak = function(s, wordDict) {
    const res = new Array(s.length + 1);
    res.fill(false);
    res[0] = true;
    for(let i = 0; i <= s.length; i++){
        if(!res[i]) continue;
        for(let j = 0; j < wordDict.length; j++){
            const item = wordDict[j];
            if(res[i] && s.substring(i, i + item.length) === item){
                if(i + item.length === s.length) return true;
                res[i + item.length] = true;
            }
        }
    }
    return res[s.length];
   
};