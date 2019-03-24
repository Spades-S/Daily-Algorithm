/**
 * @param {number[]} digits
 * @return {number[]}
 */
var plusOne = function(digits) {
    let carry = 1;
    let index = digits.length - 1;
    while(carry !== 0 && index > -1){
        const temp = digits[index] + carry;
        digits[index] = temp % 10;
        carry = Math.floor(temp / 10);
        index--;
    }
    if(carry !== 0){
        digits.unshift(carry);
    }
    return digits;
};