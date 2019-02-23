class Solution {
    public int thirdMax(int[] nums) {
        int len = nums.length;
        long[] maxs = new long[]{Long.MIN_VALUE, Long.MIN_VALUE, Long.MIN_VALUE};
        for(int num : nums){
					if(num > maxs[0]){
						maxs[2] = maxs[1];
						maxs[1] = maxs[0];
						maxs[0] = num;
					}else if(num < maxs[0] && num > maxs[1]){
						maxs[2] = maxs[1];
						maxs[1] = num;
					}else if(num < maxs[1] && num > maxs[2]){
						maxs[2] = num;
					}
        }
				if(maxs[2] != Long.MIN_VALUE) return (int)maxs[2];
				return (int)maxs[0];
    }
}