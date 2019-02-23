/**
 * @param {string} s
 * @return {string}
 */
var reverseWords = function(s) {
    const chs = s.split('');
    let cnt = 0;
    let start = 0;
    for(let i = 0; i < chs.length; i++){
        if(chs[i] === ' '){
            swap(start, cnt ,chs);
            start += cnt + 1;
            cnt = 0;
        }else{
            cnt++;
        }
    }
    swap(start, cnt, chs);
    return chs.join('');
    
    
    function swap(start, cnt, chs){
        if(cnt <= 1) return;
        let end = start + cnt - 1;
        while(start < end){
            const temp = chs[start];
            chs[start] = chs[end];
            chs[end] = temp;
            start++;
            end--;
        }
    }
    
};