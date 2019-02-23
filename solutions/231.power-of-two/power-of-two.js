/**
 * @param {number} n
 * @return {boolean}
 */
var isPowerOfTwo = function(n) {
    let start = 0, end = n + 1;
    while(start < end){
        let mid = parseInt(start + (end - start)/ 2, 10);
        if(Math.pow(2, mid) === n){
            return true;
        }else if(Math.pow(2, mid) > n){
            end = mid;
        }else{
            start = mid + 1;
        }
    }
    return false;
};