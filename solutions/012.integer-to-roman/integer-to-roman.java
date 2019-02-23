class Solution {
    public String intToRoman(int num) {
        int [] value = new int[] {1000,900,500,400,100,90,50,40,10,9,5,4,3,2,1};
        String [] key = new String[] {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","III","II","I"};
        String result = "";
        int i = 0;
        int quotient = 0;
        while(num>0 || i< value.length ){
            quotient = num / value[i];
            for(int j = 0; j < quotient;j++){
                result += key[i];
            }
            num = num % value[i];
            i++;
        }
        return result;
        
    }
}