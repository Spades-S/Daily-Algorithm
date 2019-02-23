class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++){
            HashSet<Character> setRow = new HashSet<Character>();
            HashSet<Character> setCol = new HashSet<Character>();
            HashSet<Character> setSub = new HashSet<Character>();
            for(int j = 0; j < 9; j++){
                char cRow = board[i][j];
                char cCol = board[j][i];
                char cSub = board[i/3*3 + j/3][i%3*3 + j%3];
                if(cRow != '.'){
                    if(setRow.contains(cRow)) return false;
                    setRow.add(cRow);
                }
                if(cCol != '.'){
                    if(setCol.contains(cCol)) return false;
                    setCol.add(cCol);
                }
                if(cSub != '.'){
                    if(setSub.contains(cSub)) return false;
                    setSub.add(cSub);
                }
            }
        }
        return true;
    }
    
}