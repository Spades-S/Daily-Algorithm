class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<String>();
        if(board.length == 0 || board[0].length == 0 || words.length == 0){
            return result;
        }
        Arrays.sort(words);
        for(int c = 0; c < words.length; c++){
            String word = words[c];
            if(word.length()>0 && (c == 0 || !word.equals(words[c-1]))){
                char[][] temp = new char[board.length][board[0].length];
                List<Integer[]> toFinds = new ArrayList<Integer[]>();
                for(int i = 0; i < board.length; i++){
                    for(int j = 0; j < board[0].length; j++){
                        temp[i][j] = board[i][j];
                        if(temp[i][j] == word.charAt(0)){
                            toFinds.add(new Integer[]{i,j});
                        }
                    }
                }
                for(Integer[] toFind : toFinds){
                    if(dfs(toFind[0], toFind[1], 0, temp, word)){
                        result.add(word);
                        break;
                    }
                }
            }
        }
        return result;
    }
    
    private boolean dfs(int x, int y, int nth, char[][] board, String word){
        if(x < 0 || y < 0 || x >= board.length || y >= board[0].length){
            return false;
        }
        if(board[x][y] == word.charAt(nth)){
            if(nth == word.length() - 1){
                return true;
            }
            char temp = board[x][y];
            board[x][y] = '#';
            if(dfs(x-1, y, nth+1, board, word)
               || dfs(x+1, y, nth+1, board, word)
               || dfs(x, y-1, nth+1, board, word)
               || dfs(x, y+1, nth+1, board, word)){
                return true;
            }
            board[x][y] = temp;
        }
        return false;
    }
}