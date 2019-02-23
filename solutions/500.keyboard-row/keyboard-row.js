/**
 * @param {string[]} words
 * @return {string[]}
 */
var findWords = function(words) {
    const map = [1, 2, 2, 1, 0, 1, 1, 1, 0, 1, 1, 1, 2, 2, 0, 0, 0, 0, 1, 0, 0, 2, 0, 2, 0, 2];
    const res = [];
    for(let word of words){
        const lowercase = word.toLowerCase();
        const row = map[lowercase[0].charCodeAt(0) - 'a'.charCodeAt(0)];
        let isRequested = true;
        for(let i = 1; i < lowercase.length; i++){
            if(map[lowercase[i].charCodeAt(0) - 'a'.charCodeAt(0)] !== row){
                isRequested = false;
            }
        }
        if(isRequested){
           res.push(word); 
        }
    }
    return res;
};