class Solution {
    public String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        int end = -1;
        Boolean hasBreaked = false;
        if(length==0){
            return "";
        }else if(length == 1){
            return strs[0];
        }else{
            for(int i =0;i<strs[0].length();i++){
          
                
                for(int j = 1;j<length;j++){
                   try{
                    if(strs[j].charAt(i)!=strs[0].charAt(i)){
                        hasBreaked = true;
                        break;
                    }
                }catch(Exception e){
                    hasBreaked = true;
                    break;
                } 
                }
                
                if(hasBreaked){
                    break;
                }else{
                    end = i+1;
                }
            }
        }
        if(end == -1){
            return "";
        }else if(end >= strs[0].length()){
            return strs[0];
        }
        return strs[0].substring(0,end);
        
        
        
    }
}