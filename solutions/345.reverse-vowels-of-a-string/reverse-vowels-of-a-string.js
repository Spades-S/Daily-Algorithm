/**
 * @param {string} s
 * @return {string}
 */
var reverseVowels = function(s) {
    const chars = s.split('');
    let start = 0, end = s.length - 1;
    while(start < end){
        if(!isVowels(chars[start])){
            start++;
        }else if(!isVowels(chars[end])){
            end--;
        }else{
            const temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp
            end--;
            start++;
        }
    }
    return chars.join('');
    
    
    function isVowels(c){
        let res = false;
        switch(c){
            case 'A':
            case 'a':
            case 'E':
            case 'e':
            case 'I':
            case 'i':
            case 'O':
            case 'o':
            case 'U':
            case 'u':
                res = true;
                break;
            default:
                break;
        }
        return res;
    }
    
};