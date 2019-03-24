/**
 * @param {number} area
 * @return {number[]}
 */
var constructRectangle = function(area) {
    let sqrt = Math.floor(Math.sqrt(area));
    let width = sqrt;
    while((area % width) !== 0){
        width--;
    }
    return [Math.floor(area / width), width];
    
};