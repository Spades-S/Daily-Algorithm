/**
 * @param {number} buckets
 * @param {number} minutesToDie
 * @param {number} minutesToTest
 * @return {number}
 */
var poorPigs = function(buckets, minutesToDie, minutesToTest) {
    let sum = 0;
    const interval = Math.floor(minutesToTest / minutesToDie) + 1;
    for(let i = 0; ; i++){
        sum = interval**i;
        console.log(sum, i)
        if(sum >= buckets){
            return i;
        }
        
    }
    return 0;
    
};