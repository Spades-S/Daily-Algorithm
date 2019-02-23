class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] subStrs = str.split(" ");
        if(subStrs.length != pattern.length()) return false;
        HashMap<Character, String> map = new HashMap<Character, String>();
        for(int i = 0; i < subStrs.length; i++){
            char c = pattern.charAt(i);
            if(map.containsKey(c)){
                if(!subStrs[i].equals(map.get(c))) return false;
            }else{
                if(map.containsValue(subStrs[i])) return false;
                map.put(c, subStrs[i]);
            }
        }
        return true;
    }
}