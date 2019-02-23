/**
 * @param {string} s
 * @param {number} k
 * @return {string}
 */
var reverseStr = function(s, k) {
    const chars = s.split('');
    let start = 0;
    while(start < s.length){
        let end = start + k - 1;
        if(end >= s.length - 1) end = s.length -1;
        swap(chars, start, end);
        start += 2*k;
    }
    return chars.join('');
    
    
    function swap(chars, start, end){
        while(end > start){
            const temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
    
};