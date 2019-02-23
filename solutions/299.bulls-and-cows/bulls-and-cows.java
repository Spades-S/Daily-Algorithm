class Solution {
    public String getHint(String secret, String guess) {
        int len = secret.length();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        char[] sStr = secret.toCharArray();
        char[] gStr = guess.toCharArray();
        int bullNum = 0, cowNum = 0;
        for(int i = 0; i < len; i++){
            char c = sStr[i];
            if(c == gStr[i]){
                bullNum ++;
                continue;
            }
            if(map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            }else{
                map.put(c, 1);
            }
        }
        for(int i = 0; i < len; i++){
            char c = gStr[i];
            if(c != sStr[i]){
                if(map.containsKey(c)){
                    int num = map.get(c);
                    if(num > 0){
                        cowNum++;
                        map.put(c, num - 1);
                    }
                }
            }
        }
        return bullNum + "A" + cowNum +"B";
    }
}