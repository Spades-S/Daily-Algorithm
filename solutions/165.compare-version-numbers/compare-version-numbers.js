/**
 * @param {string} version1
 * @param {string} version2
 * @return {number}
 */
var compareVersion = function(version1, version2) {
    const ver1Chars = version1.split('.');
    const ver2Chars = version2.split('.');
    let i = 0, j = 0;
    while(i < ver1Chars.length || j < ver2Chars.length){
        const num1 = ver1Chars[i] === undefined ? 0 : +ver1Chars[i];
        const num2 = ver2Chars[j] === undefined ? 0 : +ver2Chars[j];
        if(num1 > num2){
            return 1;
        }else if(num1 < num2){
            return -1;
        }
        i++;
        j++;
    }
    return 0;
};