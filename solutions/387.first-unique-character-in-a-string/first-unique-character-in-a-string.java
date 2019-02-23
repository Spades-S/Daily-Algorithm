class Solution {
    public int firstUniqChar(String s) {
        int min = Integer.MAX_VALUE;
        for( char c = 'a'; c <='z'; c ++){
            int first = s.indexOf( c );
            if( first != -1 && s.lastIndexOf(c) == first){
                min = Math.min( first, min );
            }
        }
        
        if( min == Integer.MAX_VALUE) return -1;
        return min;
    }
}