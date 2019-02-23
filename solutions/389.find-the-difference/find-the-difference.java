class Solution {
    public char findTheDifference(String s, String t) {
        char res = ' ';
        int[] nums = new int[26]; 
        for(char c : s.toCharArray()){
            nums[c - 'a']++;
        }
        for(char c : t.toCharArray()){
           if(nums[c - 'a'] == 0){
               res = c;
               break;
           }else{
               nums[c - 'a']--;
           }
        }
        return res;
    }
}