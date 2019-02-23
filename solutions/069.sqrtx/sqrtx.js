/**
 * @param {number} x
 * @return {number}
 */
var mySqrt = function(x) {
    let start = 1, end = x + 1;
    while(start < end){
        let mid = parseInt(start + (end - start) / 2, 10);
        if(mid*mid === x){
            return mid;
        }else if(mid*mid > x){
            end = mid;
        }else{
            start = mid + 1;
        }
    }
    return start - 1;
};