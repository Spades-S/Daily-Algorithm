/**
 * @param {string[]} strs
 * @return {string}
 */
var longestCommonPrefix = function(strs) {
    let strsLength = strs.length
    if(strsLength === 0)
        return ''
    for(let i = 0;;i++){
        for(let j =0;j<strsLength;j++){
            let item =''
            if(!strs[j][i]){
                return strs[j]
            }else{
                if(strs[j][i]!==strs[0][i]){
                    return strs[0].slice(0,i)
                  
                }
            }
        }
       
      
        
    }
    
};