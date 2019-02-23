/**
 * @param {number} num
 * @return {string[]}
 */
var readBinaryWatch = function(num) {
    const list = [];
    allocate(num, 0, 0);
    const res = []
    list.forEach(item => {
        const min = item & 63;
        const hour = item >>> 6;
        if(min > 59 || hour > 11) return;
        if(min < 10) res.push(`${hour}:0${min}`)
        else res.push(`${hour}:${min}`);
        
    })
    return res;
    function allocate(num, layer, val){
        if(num === 0){
            list.push(val);
            return;
        }
        if(layer >= 10) return;
        allocate(num - 1, layer + 1, (val | (1 << layer)));
        allocate(num, layer + 1, val);
    }

    
};

