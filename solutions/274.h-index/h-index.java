class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int result = 0, length = citations.length;
        for(int i= 1; i<=length;i++){
            if(citations[length - i] >=i){
                result = i;
            }else{
                break;
            }
        }
        return result;
        
    }
}