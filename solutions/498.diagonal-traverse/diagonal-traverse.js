/**
 * @param {number[][]} matrix
 * @return {number[]}
 */
var findDiagonalOrder = function(matrix) {
    const res = [];
    const height = matrix.length;
    if(height === 0) return res;
    const width = matrix[0].length;
    let x = 0, y = 0;
    let upWard = true;
    while(res.length < height*width){
        res.push(matrix[x][y]);
        
         if(x === 0 && upWard){
             console.log(1)
            upWard = false;
            if(y < width - 1){
                y++;
            }else{
                x++;
            }
            continue;
        }
        if(y === width - 1  && upWard){
            console.log(2)
            upWard = false;
            x++;
            continue;
        }
        if(x === height - 1 && !upWard){
            console.log(4)
            upWard = true;
            if(y < width - 1){
                y++;
            }else{
                x--;
            }
            continue;
        }
        
        if(y === 0 && !upWard){
            console.log(3)
            upWard = true;
            x++;
            continue;
        }
 
        if(upWard){
            x--;
            y++;
        }else{
            x++;
            y--;
        }
        
       
    }
    return res;
};