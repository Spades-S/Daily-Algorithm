/**
 * @param {number} L
 * @param {number} R
 * @return {number}
 */
var countPrimeSetBits = function(L, R) {
    const prime = {
        2: true,
        3: true,
        5: true,
        7: true,
        11: true,
        13: true,
        17: true,
        19: true,
        23: true
    }
    function hammingWeight(num){
        let res = 0;
        while(num !== 0){
            if((num & 1) === 1){
                res++;
            }
            num = num >>> 1;
        }
        return res;
    }
    
    let cnt = 0;
    for(let i = L; i <= R; i++){
        if(prime[hammingWeight(i)]) cnt++;
    }
    return cnt;

    
    
};