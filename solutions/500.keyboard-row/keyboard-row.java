class Solution {
    public String[] findWords(String[] words) {
        int[] set = {1, 2, 2, 1, 0, 1, 1, 1, 0, 1, 1, 1, 2, 2, 0, 0, 0, 0, 1, 0, 0, 2, 0, 2, 0, 2};
        ArrayList<String> temp = new ArrayList<String>();
        for(String word : words){
            String lowercase = word.toLowerCase(); 
            int row = set[lowercase.charAt(0) - 'a'];
            boolean isRequested = true;
            for(int i = 1; i < lowercase.length(); i++){
                if(set[lowercase.charAt(i) - 'a'] != row){
                    isRequested = false;
                    break;
                }
            }
            if(isRequested)
             temp.add(word);
        }
        String[] res = new String[temp.size()];
        for(int i = 0; i < res.length; i++){
            res[i] = temp.get(i);
        }
        return res;
    }
}