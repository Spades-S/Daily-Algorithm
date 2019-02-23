/**
 * @param {string} str
 * @return {number}
 */
var myAtoi = function(str) {
    str = str.trim()
    let temp = ''
    let validString = '-1234567'
    for(var i = 0;i<str.length;i++){
        
        if(isNaN(Number(str.substring(0,i+1))) ){
            if(!(i===0 && (str[0]==='-'||str[0]==='+'))){
                break
            }
        }
    }
    str = str.substring(0,i)
    if(isNaN(Number(str))){
        return 0
    }else{
        let result = Number(str)
        if(result>Math.pow(2,31)-1){
            return Math.pow(2,31)-1
        }else if(result < -Math.pow(2,31)){
            return -Math.pow(2,31)    
        }else{
            return result
        }
    }
 
     
   
    
};