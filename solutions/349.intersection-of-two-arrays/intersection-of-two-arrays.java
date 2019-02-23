class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int l1 = nums1.length, l2 = nums2.length,index = 0;
        int[] temp = new int[(l1>l2?l1:l2)];
        int i = 0, j = 0;
        while(i<l1 && j<l2){
            if(nums1[i]>nums2[j]){
                j++;
            }else if(nums1[i]<nums2[j]){
                i++;
            }else{
                if(index == 0  || nums1[i] != temp[index-1]){
                    temp[index] = nums1[i];
                    index++;
                }
                j++;
                i++;
            }
        }
        
        int[] result = new int[index];
        for(int s =0; s < index;s++){
            result[s] = temp[s];
        }
        
        return result;
        
    }
}