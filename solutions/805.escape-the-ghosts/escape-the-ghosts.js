/**
 * @param {number[][]} ghosts
 * @param {number[]} target
 * @return {boolean}
 */
var escapeGhosts = function(ghosts, target) {
    const path = Math.abs(target[0]) +  Math.abs(target[1]);
    for(let ghost of ghosts){
        if(Math.abs(ghost[0] - target[0]) + Math.abs(ghost[1] - target[1]) <= path){
            return false;
        }
    }
    return true;
};