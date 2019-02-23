
class Solution {
    private class numComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2){
            return (s2 + s1).compareTo(s1 + s2);
        }
    }
    
    public String largestNumber(int[] nums) {
        String[] strArr = new String[nums.length];
        for(int i = 0; i < strArr.length; i++){
            strArr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strArr, new numComparator());
        if(strArr.length>0 && strArr[0].equals("0")){
            return "0";
        }
        StringBuilder result = new StringBuilder();
        for(String str : strArr){
            result.append(str);
        }
        return result.toString();
    }
}