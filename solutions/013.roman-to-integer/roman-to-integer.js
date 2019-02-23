/**
 * @param {string} s
 * @return {number}
 */
var romanToInt = function(s) {
    let map ={
        'I':1,
        'V':5,
        'X':10,
        'L':50,
        'C':100,
        'D':500,
        'M':1000
    }
    let length = s.length
    let result = map[s[length-1]]
    for(let i = 0;i<length-1;i++){
        if(map[s[i]]>=map[s[i+1]]){
            result += map[s[i]]
        }else{
            result -= map[s[i]]
        }
    }
    return result
    
};

