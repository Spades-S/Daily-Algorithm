class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int houseIndex = 0;
        int radius = -1;
        for(int i = 0; i < heaters.length; i++){
            int j;
            for(j = houseIndex; j < houses.length; j++){
                if(houses[j] <= heaters[i] || i == heaters.length - 1){
                    int temp = Math.abs(heaters[i] - houses[j]);
                    if(i != 0){
                        temp = Math.min(temp, Math.abs(heaters[i - 1] - houses[j]));
                    }
                    radius = Math.max(radius, temp);
                }else{
                    break;
                }
            }
            houseIndex = j;
        }
        return radius;
    }
}