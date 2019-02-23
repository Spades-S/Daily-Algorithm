class Solution {
    public int reverse(int x) {
        String str = "" + x;
        StringBuffer temp = new StringBuffer();
        if(x<0){
            str = str.substring(1);
        }
        temp = new StringBuffer(str).reverse();
        if(x<0){
            temp.insert(0,'-');
        }
        Long tempLong = Long.parseLong(temp.toString());
        if(tempLong > Math.pow(2,31)-1 || tempLong < - Math.pow(2,31)){
            return 0;
        }else{
            return Integer.parseInt(temp.toString());
        }
        
        
    }
}