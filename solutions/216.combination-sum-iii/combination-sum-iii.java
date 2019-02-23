class Solution {
    private List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        if(n < k || n > k*9){
            return res;
        }
        helper(1, k, 1, n, new int[k]);
        return res;
    }
    public void helper(int nth, int k,int start, int sum, int[] buffer){
        if(nth == k){
            if(sum >= start && sum < 10){
                List<Integer> list = new ArrayList<Integer>();
                buffer[nth - 1] = sum;
                for(int item : buffer){
                    list.add(item);
                }
                res.add(list);
            }
            return;
        }
        if(sum <= 0){
            return;
        }
        for(int i = start; i < 10; i++){
            buffer[nth - 1] = i;
            helper(nth + 1, k, i + 1,sum - i, buffer);
        }
    }
}