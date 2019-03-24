/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLastWord = function(s) {
    let start = -1;
    let len = 0;
    for(let i = s.length -1; i >= 0;i--){
        if(s[i] === ' '){
            if(start === -1){
                continue;
            }
            break;
        }else{
            if(start === -1) start = i;
            len++;
        }
    }
    return len;    
};