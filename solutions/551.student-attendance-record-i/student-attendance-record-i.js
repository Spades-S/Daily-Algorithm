/**
 * @param {string} s
 * @return {boolean}
 */
var checkRecord = function(s) {
    let absentCnt = 0;
    for(let i = 0; i < s.length; i++){
        if(s[i] === 'A'){
            absentCnt++;
            if(absentCnt > 1){
                return false;
            }
        }
        if(i > 1 && s[i] === 'L' && s[i - 1] === 'L' && s[i - 2] === 'L'){
            return false;
        }
    }
    return true;
};