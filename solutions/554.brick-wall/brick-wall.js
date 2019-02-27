/**
 * @param {number[][]} wall
 * @return {number}
 */
var leastBricks = function(wall) {
    const map = new Map();
    let brokenCnt = 0;
    for(let row of wall){;
        let sum = 0;
        for(let i = 0; i < row.length - 1; i++){
            sum += row[i];
            let cnt = 1;
            if(map.has(sum)){
                cnt += map.get(sum);
            }
            brokenCnt = Math.max(brokenCnt, cnt);
            map.set(sum, cnt);
        }
    };
  
    return wall.length - brokenCnt;
};