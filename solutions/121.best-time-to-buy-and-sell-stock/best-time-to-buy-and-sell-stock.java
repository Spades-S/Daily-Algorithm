class Solution {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if(length<2){
            return 0;
        }
        
        int result = 0;
        int start = prices[0];
        for(int i = 1; i < length; i++){
            if(prices[i] - start >= 0){
                result = result > prices[i] - start ? result : prices[i] - start;
            }else{
                start = prices[i];
            }
        }
        
        return result;
    }
}