class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        int len = nums.length;
        if(len < 1){
            return res;
        }
        int candidateA = nums[0], candidateB = nums[0], cntA = 0, cntB = 0;
        for(int i = 0; i < len; i++){
            if(nums[i] == candidateA){
                cntA++;
                continue;
            }
            if(nums[i] == candidateB){
                cntB++;
                continue;
            }
            if(cntA == 0){
                candidateA = nums[i];
                cntA++;
                continue;
            }
            if(cntB == 0){
                candidateB = nums[i];
                cntB++;
                continue;
            }
            cntA--;
            cntB--;
        }
        cntA = 0;
        cntB = 0;
        for(int i = 0; i < len; i++){
            if(nums[i] == candidateA){
                cntA++;
            }else if(nums[i] == candidateB){
                cntB++;
            }
        }
        if(cntA > len/3){
            res.add(candidateA);
        }
        if(cntB > len/3){
            res.add(candidateB);
        }
        
        return res;
    }
}