class Solution {
    public String toHex(int num) {
        char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        String res = "";
        if(num == 0) return "0";
        while(num != 0){
            int digit = num & 15;
            res = map[digit] + res;
            num >>>= 4;
        }
        
        return res;
    }
}