class Solution {
    public int[] constructRectangle(int area) {
        int length = (int)Math.sqrt(area);
        int[] res = new int[2];
        for(; length > 0; length --){
            if(area % length == 0){
                res[0] = area / length;
                res[1] = length;
                break;
            }
        }
        return res;
    }
}