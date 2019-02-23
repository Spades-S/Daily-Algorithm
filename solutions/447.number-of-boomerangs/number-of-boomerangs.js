/**
 * @param {number[][]} points
 * @return {number}
 */
var numberOfBoomerangs = function(points) {
    let res = 0;
    for(let i = 0; i < points.length; i++){
        const map = new Map(); 
        for(let j = 0; j < points.length; j++){
            if(j === i) continue;
            const dis = getDistancePow(points[i], points[j]);
            if(map.has(dis)){
                res += map.get(dis);
                map.set(dis, map.get(dis) + 1);
            }else{
                map.set(dis, 1);
            }
        }
    }
    return res*2;
    
    
    function getDistancePow(A, B){
        return (A[0] - B[0])**2 +(A[1] - B[1])**2; 
    }
    
};