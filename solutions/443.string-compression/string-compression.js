/**
 * @param {character[]} chars
 * @return {number}
 */
var compress = function(chars) {
    let index = 0;
    let cnt = 1;
    for(let i = 0; i < chars.length; i++){
        if(i === 0 || chars[i] !== chars[i - 1]){
            if(cnt !== 1){
                index = addCnt(chars, index, cnt);
                cnt = 1;
            }
            chars[index++] = chars[i];
        }else{
            cnt++;
        }
    }
    if(cnt !== 1){
        index = addCnt(chars, index, cnt);
    }
    
    function addCnt(arr, index, cnt){
        cnt += '';
        for(let i = 0; i< cnt.length; i++){
            arr[index++] = cnt[i];
        }
        return index;
    }
    return index;
    
};