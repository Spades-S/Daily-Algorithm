/**
 * @param {string} s
 * @param {number} numRows
 * @return {string}
 */
var convert = function(s, numRows) {
    if(numRows === 1) return s;
    const res = new Array(numRows);
    for(let i = 0; i < numRows; i++){
        res[i] = '';
    }
    let start = 0;
    while(start < s.length){
        for(let i = 0; i < 2*numRows - 2  && start < s.length; i++){
            if(i < numRows){
                res[i]+= s[start++];
            }else{
                res[2*numRows - 2 - i] += s[start++];
            }
        }
    }
    let str = '';
    res.forEach(item => {
        str += item;
    })
    return str;
};