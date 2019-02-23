/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
 let stack = []
 let length = s.length
 for(let i = 0;i<length;i++){
    switch(s[i]){
        case '[':
            stack.push(']')
            break;
        case '{':
            stack.push('}')
            break;
        case '(':
            stack.push(')')
            break;
            default:
            if(stack.length ===0 || stack.pop() !== s[i]){
                return false
            }
            
    }
 }
    return (stack.length===0)
    
};