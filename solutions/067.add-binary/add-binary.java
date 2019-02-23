class Solution {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int toAdd = 0;
        int lenA = a.length(), lenB = b.length();
        int len = Math.max(lenA, lenB);
        for(int i = 0; i < len; i++){
            char charA = i < lenA ? a.charAt(lenA - 1- i) : '0';
            char charB = i < lenB ? b.charAt(lenB -1 - i) : '0';
            int sum = charA - '0' + charB - '0' +toAdd;
            res.insert(0, sum % 2);
            toAdd = sum / 2;
        }
       
        if(toAdd != 0){
            res.insert(0, toAdd);
        }
        return res.toString();
    }
}