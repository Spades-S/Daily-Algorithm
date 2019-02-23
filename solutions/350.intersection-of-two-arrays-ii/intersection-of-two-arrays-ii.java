class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int l1 = nums1.length, l2 = nums2.length;
        if(l1*l2 == 0){
            return new int[0];
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0, index =0;
        int[] temp = new int[(l1>l2?l1:l2)];
        while(i<l1 && j<l2){
            if(nums1[i]>nums2[j]){
                j++;
            }else if(nums1[i]<nums2[j]){
                i++;
            }else{
                temp[index] = nums1[i];
                index++;
                i++;
                j++;
            }
        }
        return Arrays.copyOf(temp, index);
    }
}