/**
 * @param {string} s
 * @return {number}
 */
var numDecodings = function(s) {
    const res = [];
    if(s[0] == 0){
        return 0;
    }else{
        res.push(1);
    }
    if(s.length === 1){
        return res[0];
    }
    if(s[1] == 0){
        if(s[0] > 2) return 0;
        res.push(1);
    }else if(s[0] > 2 || (s[0] == 2 && s[1] > 6)){
        res.push(1);
    }else{
        res.push(2);
    }
    
   
    for(let i = 2; i < s.length; i++){
        if(s[i] == 0){
            if(s[i - 1] == 0 || s[i - 1] > 2) return 0;
            res[i - 1] = res[i - 2];
            res.push(res[i - 1]);
        }else if(s[i - 1] == 0 || s[i - 1] > 2 || (s[i - 1] == 2 && s[i] > 6)){
            res.push(res[i - 1]);
        }else{
            res.push(res[i - 1] + res[i - 2]);
        }
    }
    return res[s.length - 1];
};