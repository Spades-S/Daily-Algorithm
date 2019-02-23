/**
 * @param {number[]} houses
 * @param {number[]} heaters
 * @return {number}
 */
var findRadius = function(houses, heaters) {
    houses.sort((a, b) => a - b);
    heaters.sort((a, b) => a- b);
    let houseIndex = 0;
    let radius = -1;
    for(let i = 0; i < heaters.length; i++){
        let j;
        for(j = houseIndex; j < houses.length; j++){
            if(houses[j] <= heaters[i] || i === heaters.length - 1){
                let temp = Math.abs(heaters[i] - houses[j]);
                if(i !== 0){
                    temp = Math.min(temp, Math.abs(heaters[i - 1] - houses[j]));
                }
                radius = Math.max(radius, temp);
            }else{
                break;
            }
        }
        houseIndex = j;
    }
    return radius;
};