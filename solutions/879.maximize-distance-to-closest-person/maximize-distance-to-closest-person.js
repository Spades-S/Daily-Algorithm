/**
 * @param {number[]} seats
 * @return {number}
 */
var maxDistToClosest = function(seats) {
    
    let pre = -1, cur = -1, curDis = 0;
    let start = -1, end = -1, dis = 0;
    for(let i = 0; i < seats.length; i++){
        if(seats[i] === 0){
            curDis++;
            if(i === seats.length - 1){
                pre = cur;
                cur = i;
                if((start === -1 && curDis > dis) || (start !== -1 && curDis > dis/2)){
                    start = pre;
                    end = seats.length;
                    dis = curDis;
                }
                curDis = 0;
            }
        }else{
            pre = cur;
            cur = i;
            if((curDis >= dis&&start !== -1) || (start === -1 && curDis >= 2*dis)){
                start = pre;
                end = cur;
                dis = curDis;
            }
            curDis = 0;
        }
    }
    if(start === -1) return end;
    if(end === seats.length) return seats.length - 1 - start;
    const index =  Math.floor(start + (end - start) / 2);
    return Math.min(index - start, end - index);
};