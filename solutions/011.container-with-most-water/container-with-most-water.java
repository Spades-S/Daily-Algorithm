class Solution {
    public int maxArea(int[] height) {
        int result = 0,start=0,end=height.length-1;
        while(start<end){
            result = Math.max(result,(end-start)*Math.min(height[start],height[end]));
            if(height[start]<height[end]){
                start++;
            }else{
                end--;
            }
        }
        return result;
    }
}