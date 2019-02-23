/**
 * @param {number} num
 * @return {string}
 */
var convertToBase7 = function(num) {
    if(num === 0) return '0';
    let symbol = '';
    if(num < 0){
        num = - num;
        symbol += '-';
    }
    let content = ''
    while(num > 0){
        const remainder = num % 7;
        content = remainder + content;
        num = (num - remainder) / 7 ;
    }
    return symbol + content;
    
};