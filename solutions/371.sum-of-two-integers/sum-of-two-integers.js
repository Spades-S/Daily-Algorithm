/**
 * @param {number} a
 * @param {number} b
 * @return {number}
 */
var getSum = function(a, b) {
    let carry = (a&b) << 1;
    let sum = a ^ b;
    while(carry !== 0){
        const lastSum = sum;
        const lastCarry = carry;
        carry = (lastCarry & lastSum) << 1;
        sum = lastCarry^lastSum;
    }
    return sum;
};