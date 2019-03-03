/**
 * @param {number} dividend
 * @param {number} divisor
 * @return {number}
 */
var divide = function(dividend, divisor) {
    const isPostive = ((dividend >= 0 && divisor >0) || (dividend <= 0 && divisor < 0)) ? true : false;
    dividend = Math.abs(dividend);
    divisor = Math.abs(divisor);
    let res = 0;
    if(divisor === 1) res = dividend;
    else{
       while(dividend >= divisor){
            let temp = divisor;
            for(let i = 0; dividend >= temp; i++){
                res += (1 << i);
                dividend -= temp;
                temp <<= 1;
                if(temp <= 0) break;
            }
        }  
    }
   
    return (isPostive ? Math.min(res, 2**31 - 1) : -Math.min(res, 2**31));
};