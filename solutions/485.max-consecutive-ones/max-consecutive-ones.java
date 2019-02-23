class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int cnt = 0;
        for(int num : nums){
            if(num == 0){
                if(cnt != 0){
                    res = Math.max(res, cnt);
                    cnt = 0;
                }
                 
            }else{
                cnt++;
            }
        }
        res = Math.max(res, cnt);
        return res;
    }
}