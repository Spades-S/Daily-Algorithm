/**
 * @param {number} x
 * @return {boolean}
 */
var isPalindrome = function(x) {
    if(x<0)
        return false
    let sourceString = String(x)
    let length = sourceString.length
    let firstPart= '', lastPart =''
    if(length%2 === 0){
        for(let i =0; i<length/2;i++){
            if(sourceString[i]!==sourceString[length-1-i])
                return false
        }
    }else{
        for(let i = 0;i<(length-1)/2;i++){
            if(sourceString[i] !== sourceString[length-1-i])
                return false
        }
    }
    return true
    
    
    
    
};