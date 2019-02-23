/**
 * @param {number[][]} grid
 * @return {number}
 */
var islandPerimeter = function(grid) {
    let res = 0;
    for(let x = 0; x < grid.length; x++){
        for(let y = 0; y < grid[0].length; y++){
            if(grid[x][y] === 1)
            res += getItem(grid, x, y);
        }
    }
    return res;
    
    function getItem(grid, x, y){
        const height = grid.length;
        const width = grid[0].length;
        let res = 0;
        if(x - 1 < 0 || grid[x-1][y] === undefined || grid[x-1][y] === 0){
            res++;
        }
        if(x + 1 >= height || grid[x+1][y] === undefined || grid[x+1][y] === 0){
            res++;
        }
        if(grid[x][y - 1] === undefined || grid[x][y - 1] === 0){
            res++;
        }
        if(grid[x][y + 1] === undefined || grid[x][y + 1] === 0){
            res++;
        }
        return res;
    }
    
};