/**
 * @param {string} s
 * @return {number}
 */
var calculate = function(s) {
    const stack = [];
    let str = '';
    let preOp = '+';
    for(let i = 0; i < s.length; i++){
        if(s[i] === ' ') continue;
        if(s[i] >= '0' && s[i] <= '9'){
            let cur = s[i++];
            while(s[i] >= '0' && s[i] <= '9'){
                cur += s[i++];
            }
            switch(preOp){
                case '+':
                    stack.push(+cur);
                    break;
                case '-':
                    stack.push(-cur);
                    break;
                case '*':
                    stack.push(stack.pop() * (+cur))
                    break;
                case '/':
                    stack.push(parseInt(stack.pop() / (+cur), 10));
                    break;
                default:
                    break;
            }
        }
        preOp = s[i];
    }
    
    return stack.reduce((acc, current) => acc  + current);
    
};