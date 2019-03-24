/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
    const stack = [];
    for(let c of s){
        switch(c){
            case '(':
            case '{':
            case '[':
                stack.push(c);
                break;
            case ')':
                if(stack.pop() !== '('){
                    return false;
                }
                break;
            case ']':
                if(stack.pop() !== '['){
                    return false;
                }
                break;
            case '}':
                if(stack.pop() !== '{'){
                    return false;
                }
                break;
            default:
                break;
        }
    }
    if(stack.length !== 0) return false;
    return true;
};