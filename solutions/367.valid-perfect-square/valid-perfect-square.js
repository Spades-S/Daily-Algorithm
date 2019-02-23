/**
 * @param {number} num
 * @return {boolean}
 */
var isPerfectSquare = function(num) {
    let start = 1, end = num + 1;
    let res = false;
    while(start < end){
        let mid = parseInt(start + (end - start) / 2, 10);
        if(mid*mid === num){
            res = true;
            break;
        }else if(mid*mid > num){
            end = mid;
        }else{
            start = mid + 1;
        }
    }
    return res;
};