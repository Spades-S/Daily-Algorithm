/**
 * @param {number} n
 * @return {number}
 */
var findNthDigit = function(n) {
    let block = 0;
    let charDiff = 0;
    while(true){
        const blockCnt = 9*Math.pow(10, block)*(block + 1);
        if(blockCnt >= n){
            charDiff = n;
            break;
        }
        block++;
        n -= blockCnt;
    }
    const start = Math.pow(10, block);
    console.log(charDiff, block)
    const num = start + parseInt((charDiff - 1) / (block + 1));
    const index = (charDiff - 1) % (block + 1);
    return num.toString(10).charAt(index);
    
};