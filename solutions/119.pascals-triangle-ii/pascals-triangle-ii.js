/**
 * @param {number} rowIndex
 * @return {number[]}
 */
var getRow = function(rowIndex) {
    if(rowIndex === 0){
        return [1]
    }
    let pre = [1]
    for(let i = 0; i<= rowIndex; i++){
        let temp = []
        for(let j = 0; j < i; j++){
            temp[j] = pre[j] + (j === 0 ? 0 : pre[j-1])
        }
        temp[i] = 1
        pre = temp
    }
    return pre
};