/**
 * @param {string} a
 * @param {string} b
 * @return {string}
 */
var complexNumberMultiply = function(a, b) {
    let [num1, complex1] = a.split('+');
    let [num2, complex2] = b.split('+');
    num1 = +num1;
    num2 = +num2;
    complex1 = +(complex1.replace('i', ''));
    complex2 = +(complex2.replace('i', ''));
    const num = num1*num2 - complex1*complex2;
    const complex = num1*complex2 + num2*complex1;
    return `${num}+${complex}i`;
};