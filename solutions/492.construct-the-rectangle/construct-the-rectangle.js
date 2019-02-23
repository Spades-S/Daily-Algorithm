/**
 * @param {number} area
 * @return {number[]}
 */
var constructRectangle = function(area) {
    const res = [];
    let L = Math.ceil(Math.sqrt(area));
    for(let i = L; ;i++){
        if(area % i === 0){
            res[0] = i;
            res[1] = Math.floor(area / i);
            break;
        }
    }
    return res;
};