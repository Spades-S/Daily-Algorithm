class Solution {
    public String addStrings(String num1, String num2) {
        int carry = 0;
        String res = "";
        int len1 = num1.length(), len2 = num2.length();
        for(int i = 0; ;i++){
            if(i >= len1 && i >= len2){
                if(carry != 0)
                    res = carry + res;
                return res;
            }
            int item1 = 0, item2 = 0;
            if(i < len1){
                item1 = num1.charAt(len1 - 1 - i) - '0';
            }
            if(i < len2){
                item2 = num2.charAt(len2 - 1 - i) - '0';
            }
            res = (item1+item2+carry) % 10 + res;
            carry = (item1+item2+carry) / 10;
        }
    }
}