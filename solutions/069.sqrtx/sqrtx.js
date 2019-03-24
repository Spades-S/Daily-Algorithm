/**
 * @param {number} x
 * @return {number}
 */
var mySqrt = function(x) {
    
    let left = 1, right = x;
    while(left < right){
        let mid = Math.floor(left + (right - left) / 2);
        if(mid**2 === x){
            return mid;
        }else if(mid**2 > x){
            right = mid;
        }else{
            left = mid + 1;
        }
    }
    if(left** 2 > x) return left - 1;
    return left;
};