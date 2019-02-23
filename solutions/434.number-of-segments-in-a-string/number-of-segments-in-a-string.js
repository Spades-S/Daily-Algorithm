/**
 * @param {string} s
 * @return {number}
 */
var countSegments = function(s) {
    const strs = s.split(/\s+/);
  
    
    return   strs.filter((str)=>{
        return str !== '';
    }).length;
};