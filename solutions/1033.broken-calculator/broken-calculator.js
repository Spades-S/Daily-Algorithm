/**
 * @param {number} X
 * @param {number} Y
 * @return {number}
 */
var brokenCalc = function(X, Y) {
    if(X > Y) return X - Y;
    if(X === Y) return 0;
    let count = 0;
    while(Y > X){
        Y = (Y % 2 === 0) ? Y / 2 : Y + 1;
        count++;
    }
    return X - Y + count; 
};