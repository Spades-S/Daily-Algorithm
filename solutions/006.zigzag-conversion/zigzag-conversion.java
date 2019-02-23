class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1){
            return s;
        }
        String[] result = new String[numRows];
        for(int i = 0;i<numRows;i++){
            result[i] = "";
        }
        for(int i = 0;i<s.length();i++){
            int whichRow = i%(2*numRows-2); 
            if(whichRow < numRows){
                result[whichRow] = result[whichRow] + s.charAt(i);
            }else{
                result[2*numRows-2 - whichRow] = result[2*numRows-2 - whichRow]  +  s.charAt(i);
            }
        }

        return String.join("",result);
        
    }
}