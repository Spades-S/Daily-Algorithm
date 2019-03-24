/**
 * @param {string[]} words
 * @param {string} order
 * @return {boolean}
 */
var isAlienSorted = function(words, order) {
    const map = new Map();
    for(let i = 0; i < order.length; i++){
        map.set(order[i], i);
    }
    
    for(let index = 1; index < words.length; index++){
        const flag = helper(words[index - 1], words[index]);
        if(!flag){
            return false;
        }
    }
    return true;
    
    function helper(word1, word2){
        let i = 0, j = 0;
        while(i < word1.length && j < word2.length){
            const idx1 = map.get(word1[i++]);
            const idx2= map.get(word2[j++]);
            if(idx1 > idx2){
                return false;
            }else if(idx1 < idx2){
                return true;
            }
        }
        if(i === word1.length){
            return true;
        }
        return false;
    }
};