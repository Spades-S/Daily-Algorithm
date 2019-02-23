class Solution {
    private boolean once = false;
    public int minimumTotal(List<List<Integer>> triangle) {
        int sum = triangle.get(0).get(0);
        // helper(triangle, 0, 0, sum);
        int[] tempArr = new int[triangle.size()];
        tempArr[0] = sum; 
        for(int i = 1; i < triangle.size(); i++){
            for(int  j = i;j >= 0; j--){
                if(j == 0){
                    tempArr[j] = tempArr[j] + triangle.get(i).get(j);
                }else if(j == i){
                    tempArr[j] = tempArr[j-1] +  triangle.get(i).get(j);
                }else{
                    tempArr[j] = Math.min(tempArr[j], tempArr[j - 1]) + triangle.get(i).get(j);
                }
                if((i == triangle.size() -1) && (j == i || tempArr[j]<sum)){
                    sum = tempArr[j];
                }
            }
        }
        return sum;
    }
    // public void helper(List<List<Integer>> triangle, int nth, int index, int currentSum){
    //     if(nth == triangle.size()){
    //         if(!once) {
    //             once = true;
    //             sum = currentSum;
    //         }else{
    //             if(sum > currentSum) sum = currentSum;
    //         }
    //         return;
    //     }
    //     currentSum += triangle.get(nth).get(index);
    //     helper(triangle, nth + 1, index, currentSum);
    //     helper(triangle, nth + 1, index + 1,currentSum);
    // }
}